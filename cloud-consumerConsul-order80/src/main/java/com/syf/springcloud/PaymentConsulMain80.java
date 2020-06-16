package com.syf.springcloud;

import com.syf.manageRule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud
 * @Author: syf
 * @Date: 2020/5/17 17:35
 * @Description: 主启动
 * @Version:
 */

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "consul-provider-payment",configuration = MyRule.class)
public class PaymentConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain80.class,args);
    }
}
