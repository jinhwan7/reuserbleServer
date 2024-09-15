package com.reusable_server.reusableServer.member.presentation.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record MemberCreateDTO(@NotBlank @Size(min = 2, max = 50) String name,

							  @NotBlank @Size(min = 8, max = 30) String password,

							  @NotBlank @Email String email) {

}






