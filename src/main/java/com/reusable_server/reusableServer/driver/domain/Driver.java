package com.reusable_server.reusableServer.driver.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Driver {
	private Long driverId;
	private String state;
	private String email;
	private String name;
	private String password;
	private LocalDateTime createdDateTime;
	private LocalDateTime deletedDateTime;

	@Builder
	public Driver(
		Long driverId,
		String state,
		LocalDateTime createdDateTime,
		LocalDateTime deletedDateTime,
		String name,
		String password,
		String email) {

		this.driverId = driverId;
		this.state = state;
		this.createdDateTime = createdDateTime;
		this.deletedDateTime = deletedDateTime;
		this.name = name;
		this.password = password;
		this.email = email;
	}

}
