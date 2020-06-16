package com.syf.springcloud.controller;

import com.syf.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.syf.springcloud.entities.CommonResult;
import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {

    @Resource
    private RestTemplate restTemplate;

    private static final String INVOKE_URL = "http://cloud-payment-service";
    @GetMapping(value = "/order/zk")
    public String getZookeeper(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        log.info("结果："+result);
        return result;
    }
    @GetMapping(value = "order/create")
    public CommonResult<Payment> create(){
        CommonResult result = restTemplate.getForObject(INVOKE_URL + "/payment/create", CommonResult.class);
        log.info("结果："+result);
        return result;
    }
    @GetMapping(value = "order/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        CommonResult result = restTemplate.getForObject(INVOKE_URL + "/payment/get/"+id, CommonResult.class);
        log.info("结果："+result);
        return result;
    }
}
