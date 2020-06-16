package com.syf.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.config
 * @Author: syf
 * @Date: 2020/6/1 16:20
 * @Description:
 * @Version:
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) throws Exception{
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        StringRedisSerializer string = new StringRedisSerializer();
//        redisTemplate.setValueSerializer(string);
//        redisTemplate.setHashKeySerializer(string);
        return redisTemplate;
    }
}
