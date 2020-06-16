package com.syf.springcloud.controller;

import com.syf.springcloud.entities.Payment;
import com.syf.springcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import com.syf.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/5/18 21:15
 * @Description:
 * @Version:
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/order/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> payment = orderFeignService.getPaymentById(id);
        return payment;
    }

    @GetMapping("/order/timeout")
    public String feignTimeOut(){
        return orderFeignService.feignTimeOut();
    }
}
