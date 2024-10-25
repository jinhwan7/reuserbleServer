package com.reusable_server.reusableServer.driver.domain;


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

	@Builder
	public Driver(
		Long id,
		String state,
		String name,
		String password,
		String email) {

		this.id = id;
		this.state = state;
		this.name = name;
		this.password = password;
		this.email = email;
	}

}
