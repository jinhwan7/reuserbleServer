package com.reusable_server.reusableServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis 설정을 위한 클래스입니다.
 * 이 클래스는 Redis 연결 및 RedisTemplate 구성을 담당합니다.
 */
@Configuration
public class RedisConfig {

    /**
     * Redis 서버의 호스트 주소입니다.
     * application.properties 파일에서 'spring.data.redis.host' 값을 주입받습니다.
     */
    @Value("${spring.data.redis.host}")
    private String host;

    /**
     * Redis 서버의 포트 번호입니다.
     * application.properties 파일에서 'spring.data.redis.port' 값을 주입받습니다.
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
    //커서가 만들어준 코드 : 이 설정은 나중에 쓰게 되면 풀어서 쓰자
    // @Bean
    // public RedisTemplate<String, Object> redisTemplate() {
    //     RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    //     redisTemplate.setConnectionFactory(redisConnectionFactory());

    //     // String 타입의 key를 위한 Serializer 설정
    //     redisTemplate.setKeySerializer(new StringRedisSerializer());
    //     // Object 타입의 value를 위한 JSON Serializer 설정

    //     redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

    //     // Hash Operation을 위한 Serializer 설정
    //     redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    //     redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

    //     return redisTemplate;
    // }
} 

//redis template 이란?
//redis 에 저장된 데이터를 조회하고 조작하기 위한 인터페이스

// RedisTemplate은 Spring Data Redis 프로젝트에서 제공하는 중심 클래스입니다.
// Redis 서버와의 모든 통신을 처리합니다. 직접적인 연산이 필요한 경우나 복잡한 연산을 처리하는 경우에 주로 사용됩니다.
// Redis와의 상호작용을 위한 저수준의 라이브러리로 볼 수 있습니다.