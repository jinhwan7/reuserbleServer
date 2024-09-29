package com.reusable_server.reusableServer.member.presentation.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record MemberUpdateRequest(@Size(min = 2, max = 50) String name,
								  @Email String email,
								  @Size(min = 8, max = 30) String password) {
}

















