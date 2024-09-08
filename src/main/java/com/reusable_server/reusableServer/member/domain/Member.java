package com.reusable_server.reusableServer.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
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

	// Default constructor
	public Member() {}

	// Constructor with fields
	public Member(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// You might want to override equals(), hashCode(), and toString() methods
}