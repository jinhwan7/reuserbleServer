package com.reusable_server.reusableServer.driver.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reusable_server.reusableServer.common.enums.ReturnCode;
import com.reusable_server.reusableServer.common.exception.ReuserbleException;
import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.driver.application.dtos.DriverCreateParam;
import com.reusable_server.reusableServer.driver.infra.DriverEntity;
import com.reusable_server.reusableServer.driver.infra.DriverRepository;
import com.reusable_server.reusableServer.member.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverService {

	private final DriverRepository driverRepository;

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

	public List<Driver> findAll() {
		List<DriverEntity> driverEntities =driverRepository.findAll();

		return driverEntities.stream()
			.map(driverEntity -> driverEntity.toDomain())
			.collect(Collectors.toList());
	}


} 
