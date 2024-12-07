package com.reusable_server.reusableServer.driver.presentation.dto.response;

import com.reusable_server.reusableServer.driver.domain.Driver;
import com.reusable_server.reusableServer.match.domain.Location;

import lombok.Getter;

@Getter
public class DriverItemResponse {

	private Long id;

	private String state;
	private String email;
	private String name;
	private Location location;

	public static DriverItemResponse of(Driver driver) {
		DriverItemResponse response = new DriverItemResponse();
		response.id = driver.getId();
		response.name = driver.getName();
		response.email = driver.getEmail();
		response.state = driver.getState();
		response.location = driver.getLocation();
		return response;
	}
}
