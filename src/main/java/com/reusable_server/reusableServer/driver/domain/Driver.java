package com.reusable_server.reusableServer.driver.domain;

import java.time.LocalDateTime;

import com.reusable_server.reusableServer.match.domain.Location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Driver {

	private Long id;

	private String state;
	private String email;
	private String name;
	private String password;
	private Location location;

	@Builder
	public Driver(
		Long id,
		String state,
		String name,
		String password,
		String email,
		Location location) {
		this.id = id;
		this.state = state;
		this.name = name;
		this.password = password;
		this.email = email;
		this.location = location;
	}

}
