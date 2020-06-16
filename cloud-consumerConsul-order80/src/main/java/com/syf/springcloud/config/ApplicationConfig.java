package com.syf.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.config
 * @Author: syf
 * @Date: 2020/5/17 17:36
 * @Description: 配置restTemplate
 * @Version:
 */

@Configuration
public class ApplicationConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
