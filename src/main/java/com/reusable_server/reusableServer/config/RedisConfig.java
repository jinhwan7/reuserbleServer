package com.reusable_server.reusableServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * Redis 서버의 호스트 주소입니다.
     */
    @Value("${spring.data.redis.host}")
    private String host;

    /**
     * Redis 서버의 포트 번호입니다.
     */
    @Value("${spring.data.redis.port}")
    private int port;

    /**
     * Redis 연결을 위한 RedisConnectionFactory 빈을 생성합니다.
     *
     * @return LettuceConnectionFactory 인스턴스
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    /**
     * Redis 작업을 위한 RedisTemplate 빈을 생성합니다.
     * 이 템플릿은 String 타입의 키와 Object 타입의 값을 사용합니다.
     *
     * @return 구성된 RedisTemplate 인스턴스
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());

        // String 타입의 key를 위한 Serializer 설정
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // Object 타입의 value를 위한 JSON Serializer 설정
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // Hash Operation을 위한 Serializer 설정
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        return redisTemplate;
    }
}