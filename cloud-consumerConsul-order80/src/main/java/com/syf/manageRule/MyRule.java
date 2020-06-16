package com.syf.manageRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: cloud
 * @Package: com.syf.manageRule
 * @Author: syf
 * @Date: 2020/5/18 11:15
 * @Description: 负载均衡-随机
 * @Version:
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRUle(){
        return new RandomRule();
    }

}
