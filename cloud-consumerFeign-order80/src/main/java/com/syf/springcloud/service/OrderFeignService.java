package com.syf.springcloud.service;

import com.syf.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.syf.springcloud.entities.CommonResult;
/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/5/18 21:12
 * @Description: 创建服务调用接口
 * @Version:
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface OrderFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/timeout")
    String feignTimeOut();
}
