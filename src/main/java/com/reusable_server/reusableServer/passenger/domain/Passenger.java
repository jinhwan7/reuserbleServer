package com.reusable_server.reusableServer.passenger.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Passenger {
	private Long passengerId;
	private String email;
	private String name;
	private String password;
	private LocalDateTime createdDateTime;
	private LocalDateTime deletedDateTime;

	@Builder
	public Passenger(
		Long passengerId,
		LocalDateTime createdDateTime,
		LocalDateTime deletedDateTime,
		String name,
		String password,
		String email) {

		this.passengerId = passengerId;
		this.createdDateTime = createdDateTime;
		this.deletedDateTime = deletedDateTime;
		this.name = name;
		this.password = password;
		this.email = email;
	}
}
