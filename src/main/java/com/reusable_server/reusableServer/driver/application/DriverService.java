package com.reusable_server.reusableServer.driver.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.geo.*;

import com.reusable_server.reusableServer.common.enums.DriverStateCode;
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
			.state(DriverStateCode.IDLE)
			.build();
		DriverEntity driverEntity = DriverEntity.fromDomain(driver);
		DriverEntity savedEntity = driverRepository.save(driverEntity);
		return savedEntity.toDomain();
	}

	public Driver findOne(Long id) {
		DriverEntity driverEntity = driverRepository.findById(id)
			.orElseThrow(() -> new ReuserbleException(ReturnCode.NOT_FOUND_ENTITY));
		Driver driver = driverEntity.toDomain();
		return driver;
	}

	@Cacheable(value = "drivers", key = "'all'")
	public List<Driver> findAll() {
		List<DriverEntity> driverEntities = driverRepository.findAll();
		List<Driver> drivers = driverEntities.stream().map(DriverEntity::toDomain).collect(Collectors.toList());
		return drivers;
	}

	public List<String> findDriversWithLocation(Double latitude, Double longitude) {
		String key = "driver:locations";
		Distance radius = new Distance(5, Metrics.KILOMETERS);
		Circle circle = new Circle(new Point(longitude, latitude), radius);

		GeoResults<RedisGeoCommands.GeoLocation<Object>> results = redisTemplate.opsForGeo()
			.radius(key, circle);

		List<String> driverIds = results.getContent().stream()
			.map(result -> (String)result.getContent().getName())
			.collect(Collectors.toList());

		return driverIds;
	}

	public void updateLocation(Long driverId, Location location) {
		String key = "driver:locations";
		redisTemplate.opsForGeo()
			.add(key, new Point(location.getLongitude(), location.getLatitude()), driverId.toString());
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
