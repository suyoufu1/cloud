package com.syf.springcloud.controller;

import com.syf.springcloud.entities.CommonResult;
import com.syf.springcloud.entities.Payment;
import com.syf.springcloud.service.PaymentService;
import com.syf.springcloud.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.controller
 * @Author: syf
 * @Date: 2020/6/1 16:03
 * @Description:
 * @Version:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    private RedisService redisService;
    @PostMapping(value = "/payemtn/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result < 0){
            log.info("数据库连接失败，未插入数据");
            return new CommonResult(443,"数据库连接失败，未插入数据",null);
        }else {
            log.info("数据库插入成功");
            return new CommonResult(200,"数据库插入成功",result);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = redisService.selectById(id);
        if(null == payment){
            return new CommonResult(445,"获取失败",null);
        }else{
            return new CommonResult(200,"获取成功",payment);
        }
    }
}
