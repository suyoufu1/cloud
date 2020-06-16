package com.syf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/5/17 17:19
 * @Description: 支付接口
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort ;
    @GetMapping(value = "/payment/consul")
    public String consul(){
        return "spring cloud consul "+ serverPort +"\t"+ UUID.randomUUID().toString();
    }
}
