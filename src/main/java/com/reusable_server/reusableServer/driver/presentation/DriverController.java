package com.reusable_server.reusableServer.driver.presentation;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reusable_server.reusableServer.common.dto.ApiResponse;
import com.reusable_server.reusableServer.driver.application.DriverService;
import com.reusable_server.reusableServer.driver.presentation.dto.request.DriverSignUpRequest;
import com.reusable_server.reusableServer.driver.application.dtos.DriverCreateParam;
import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.driver.presentation.dto.response.DriverItemResponse;
import com.reusable_server.reusableServer.driver.presentation.dto.response.DriverListResponse;
import com.reusable_server.reusableServer.driver.presentation.dto.response.DriverSignupResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {

	private final DriverService driverService;

	@PostMapping("/signup")
	public ApiResponse<?> signUp(@Valid @RequestBody DriverSignUpRequest driverSignUpDTO) {
		DriverCreateParam driverCreateParam = DriverCreateParam.from(driverSignUpDTO);
		Driver createdDriver = driverService.createDriver(driverCreateParam);
		DriverSignupResponse driverSignupResponse = DriverSignupResponse.of(createdDriver);
		return ApiResponse.of(driverSignupResponse);
	}

	@GetMapping("/{id}")
	public ApiResponse<?> findOne(@PathVariable Long id) {
		Driver driver = driverService.findOne(id);
		DriverItemResponse driverItemResponse = DriverItemResponse.of(driver);
		return ApiResponse.of(driverItemResponse);

	}

	// 여기에 Redis 적용?
	@GetMapping()
	public ApiResponse<?> findAll(@PathVariable Long id) {
		List<Driver> drivers = driverService.findAll();
		DriverListResponse driverListResponse = DriverListResponse.of(drivers);
		return ApiResponse.of(driverListResponse);
	}

}