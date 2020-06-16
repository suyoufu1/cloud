package com.syf.springcloud.controller;

import com.syf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/5/19 14:21
 * @Description:
 * @Version:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/payment/timeout")
    public String getTimeOutThread( ){
        return paymentService.getTimeOutThread();
    }

    //===========服务熔断

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        String result = paymentService.getCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }
}
