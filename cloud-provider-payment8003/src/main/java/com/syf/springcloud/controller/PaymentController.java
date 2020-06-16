package com.syf.springcloud.controller;

import com.syf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.syf.springcloud.entities.CommonResult;
import com.syf.springcloud.entities.Payment;

import javax.annotation.Resource;
import java.util.UUID;


@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/crate")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result > 0){
            log.info("插入成功，result="+result);
            return new CommonResult(200,"数据插入成功",payment);
        }else {
            log.info("插入失败，result="+result);
            return new CommonResult(444,"数据插入不成功",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            log.info("查询数据成功:"+payment);
            return new CommonResult<Payment>(200,"查询成功,端口号："+serverPort,payment);
        }else{
            log.info("查询数据失败:"+null);
            return new CommonResult<Payment>(444,"查询不成功,端口号："+serverPort,null);
        }

    }
    @GetMapping(value = "/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
