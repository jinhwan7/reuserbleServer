package com.reusable_server.reusableServer.driver.presentation.dto.response;

import java.util.List;

import com.reusable_server.reusableServer.driver.domain.Driver;

import lombok.Getter;

@Getter
public class DriverListResponse {
    private List<Driver> drivers;

    public static DriverListResponse of(List<Driver> driverList) {
        DriverListResponse response = new DriverListResponse();
        response.drivers = driverList;
        return response;
    }
} 