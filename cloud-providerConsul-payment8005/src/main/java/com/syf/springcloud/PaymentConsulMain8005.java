package com.syf.springcloud;

import org.hibernate.validator.internal.constraintvalidators.bv.time.past.PastValidatorForYear;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud
 * @Author: syf
 * @Date: 2020/5/17 17:18
 * @Description: 主启动
 * @Version:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8005.class,args);
    }
}
