package com.syf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/5/17 17:38
 * @Description: 订单接口
 * @Version:
 */

@RestController
@Slf4j
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL="http://consul-provider-payment";

    @GetMapping(value = "/order/consul")
    public String consul(){
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
