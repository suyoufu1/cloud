package com.syf.springcloud.controller;


import com.syf.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/5/20 11:43
 * @Description:
 * @Version:
 */
@RestController
@Slf4j
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/get/{id}")
    String getThread(@PathVariable("id") Long id ){
        return paymentHystrixService.getThread(id);
    }

    @GetMapping("/order/timeout")
   /* @HystrixCommand(fallbackMethod = "getTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })*/
    String getTimeOut(){
        return paymentHystrixService.getTimeOutThread();
    }
   /* public String getTimeoutHandler(){
        return "消费者：系统异常或其他错误";
    }*/
}
