package com.reusable_server.reusableServer.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 2, max = 50)
	private String name;

	@NotBlank
	@Size(min = 8, max = 30)
	private String password;

	@NotBlank
	@Email
	private String email;

	@Builder
	public Member(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

}