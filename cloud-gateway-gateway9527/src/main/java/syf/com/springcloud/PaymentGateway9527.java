package syf.com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ProjectName: cloud
 * @Package: syf.com.springcloud
 * @Author: syf
 * @Date: 2020/5/29 14:52
 * @Description:
 * @Version:
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentGateway9527 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentGateway9527.class,args);
    }
}
