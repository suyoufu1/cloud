package com.syf.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisTemplateConfig {
    @Bean
    public RedisTemplate getRedisTemplate(){
        return new RedisTemplate();
    }
}
