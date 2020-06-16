package com.syf.springcloud.controller;

import com.syf.springcloud.entities.Payment;
import com.syf.springcloud.entities.CommonResult;
import com.syf.springcloud.servie.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("数据插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入到数据库成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(443,"插入到数据库失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("获取到结果是："+payment);
        if(payment != null){
            return new CommonResult(200,"获取数据成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult(445,"获取数据失败,查询的ID:"+id,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String serverPort(){
        return serverPort;
    }
    @GetMapping(value = "/payment/timeout")
    public String feignTimeOut(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
