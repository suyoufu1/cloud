package com.syf.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/6/1 10:23
 * @Description:
 * @Version:
 */
@RefreshScope
@RestController
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort ;
    @GetMapping("/getInfo")
    public String getConfigInfo(){
        return configInfo+";==="+serverPort;
    }
}
