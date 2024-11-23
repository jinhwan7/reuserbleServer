package com.reusable_server.reusableServer.redisTest.presentation;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.reusable_server.reusableServer.common.dto.ApiResponse;
import com.reusable_server.reusableServer.common.enums.ReturnCode;
import com.reusable_server.reusableServer.redisTest.application.RedisTestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/redis")
@RequiredArgsConstructor
public class RedisTestController {

    private final RedisTestService redisTestService;

    @PostMapping("/{key}")
    public ApiResponse<?> setRedisTest(@PathVariable String key, String value) {
        redisTestService.setData(key, value);
        return ApiResponse.of(ReturnCode.SUCCESS);
    }

    @GetMapping("/{key}")
    public ApiResponse<?> getRedisTest(@PathVariable String key) {
        String value = redisTestService.getData(key);
        return ApiResponse.of(value);
    }
    
    @DeleteMapping("/{key}")
    public ApiResponse<?> deleteRedisTest(@PathVariable String key) {
        redisTestService.deleteData(key);
        return ApiResponse.of(ReturnCode.SUCCESS);
    }
} 