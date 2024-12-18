package com.reusable_server.reusableServer.driver.application.dtos;

import com.reusable_server.reusableServer.driver.presentation.dto.request.DriverSignUpRequest;

import lombok.Getter;

@Getter
public class DriverCreateParam {
    private String name;
    private String email;
    private String password;

    public static DriverCreateParam from(DriverSignUpRequest dto) {
        DriverCreateParam driverCreateParam = new DriverCreateParam();

        driverCreateParam.password = dto.getPassword();
        driverCreateParam.name = dto.getName();
        driverCreateParam.email = dto.getEmail();
        return driverCreateParam;
    }
} 