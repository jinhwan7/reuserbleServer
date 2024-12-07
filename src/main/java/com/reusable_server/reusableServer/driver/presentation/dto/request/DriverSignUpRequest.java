package com.reusable_server.reusableServer.driver.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DriverSignUpRequest {
    private String email;
    private String password;
    private String name;
} 