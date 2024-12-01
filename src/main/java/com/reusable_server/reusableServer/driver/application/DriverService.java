package com.reusable_server.reusableServer.driver.application;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;

import com.reusable_server.reusableServer.common.enums.ReturnCode;
import com.reusable_server.reusableServer.common.exception.ReuserbleException;
import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.driver.application.dtos.DriverCreateParam;
import com.reusable_server.reusableServer.driver.infra.DriverEntity;
import com.reusable_server.reusableServer.driver.infra.DriverRepository;
import com.reusable_server.reusableServer.match.domain.Location;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverService {

	private final DriverRepository driverRepository;
	private final RedisTemplate<String, Object> redisTemplate;

	public Driver createDriver(DriverCreateParam param) {

		Driver driver = Driver.builder()
			.email(param.getEmail())
			.password(param.getPassword())
			.name(param.getName())
			.state("ACTIVE")
			.build();
		DriverEntity driverEntity = DriverEntity.fromDomain(driver);
		DriverEntity savedEntity = driverRepository.save(driverEntity);
		return savedEntity.toDomain();
	}

	public Driver findOne(Long id) {
        DriverEntity driverEntity =  driverRepository.findById(id)
			.orElseThrow(() -> new ReuserbleException(ReturnCode.NOT_FOUND_ENTITY));

		return driverEntity.toDomain();
	}

	@Cacheable(value = "drivers", key = "'all'")
	public List<Driver> findAll() {
		List<DriverEntity> driverEntities = driverRepository.findAll();
		return driverEntities.stream()
			.map(DriverEntity::toDomain)
			.collect(Collectors.toList());
	}


	public void updateLocation(Long driverId, Location location) {
		String key = "driver:locations";  
		redisTemplate.opsForGeo().add(
			key,
			new Point(location.getLongitude(), location.getLatitude()),
			driverId.toString()
		);
	}


	public Location getDriverLocation(Long driverId) {
		String key = "driver:location:" + driverId;
		Location location = (Location) redisTemplate.opsForValue().get(key);
		
		if (location == null) {
			DriverEntity driver = driverRepository.findById(driverId)
				.orElseThrow(() -> new ReuserbleException(ReturnCode.NOT_FOUND_ENTITY));
			location = driver.getLocation();
			redisTemplate.opsForValue().set(key, location);
		}
		
		return location;
	}
	
	public void updateDriverState(Long driverId, String state) {
		String key = "driver:state:" + driverId;
		redisTemplate.opsForValue().set(key, state);
		
		DriverEntity driver = driverRepository.findById(driverId)
			.orElseThrow(() -> new ReuserbleException(ReturnCode.NOT_FOUND_ENTITY));
		driver.setState(state);
		driverRepository.save(driver);
	}

} 
