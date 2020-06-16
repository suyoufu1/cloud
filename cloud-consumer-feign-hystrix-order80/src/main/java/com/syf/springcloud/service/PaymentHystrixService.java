package com.syf.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/5/20 11:33
 * @Description:
 * @Version:
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentFallBackHystrix.class)
public interface PaymentHystrixService{

    @GetMapping("/payment/get/{id}")
    String getThread(@PathVariable("id") Long id );

    @GetMapping("/payment/timeout")
     String getTimeOutThread( );

}

