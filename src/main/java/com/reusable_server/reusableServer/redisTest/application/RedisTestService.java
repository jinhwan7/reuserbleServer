package com.reusable_server.reusableServer.redisTest.application;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RedisTestService {
    
    private final StringRedisTemplate stringRedisTemplate;
    
    public void setData(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }
    
    public String getData(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    
    public void deleteData(String key) {
        stringRedisTemplate.delete(key);
    }
} 