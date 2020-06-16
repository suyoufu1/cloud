package com.syf.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.config
 * @Author: syf
 * @Date: 2020/5/18 22:23
 * @Description: feign日志监控
 * @Version:
 */
@Configuration
public class LogConfig {

    @Bean
    Logger.Level getLogger(){
        return Logger.Level.FULL;
    }
}
