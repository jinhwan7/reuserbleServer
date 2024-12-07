package com.reusable_server.reusableServer.driver.presentation.dto.response;

import com.reusable_server.reusableServer.driver.domain.Driver;

import lombok.Getter;

@Getter
public class DriverSignupResponse {
	private Long id;
	private String email;
	private String name;

	// public static DriverSignupResponse from(Driver driver) {
	// 	return DriverSignupResponse.builder()
	// 		.id(driver.getId())
	// 		.email(driver.getEmail())
	// 		.name(driver.getName())
	// 		.build();
	// }

	public static DriverSignupResponse of(Driver driver) {
		DriverSignupResponse response = new DriverSignupResponse();
		response.id = driver.getId();
		response.name = driver.getName();
		response.email = driver.getEmail();
		return response;
	}
} 