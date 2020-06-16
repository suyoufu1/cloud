package com.syf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort ;
    @GetMapping("/getInfo")
    public String getInfo(){
        return configInfo+"，端口是："+serverPort;
    }
}
