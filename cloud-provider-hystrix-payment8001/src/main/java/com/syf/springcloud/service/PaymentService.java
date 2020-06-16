package com.syf.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/5/19 14:16
 * @Description: 服务降级-用全局降级
 * @Version:
 */
@Service
@DefaultProperties(defaultFallback = "getGlobalException")
public class PaymentService {


    public String getThread(Long id){
        return "线程："+Thread.currentThread().getName()+";当前ID:"+id;
    }
   /* @HystrixCommand(fallbackMethod = "getTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })*/
    @HystrixCommand
    public String getTimeOutThread(){
//        try{
//             TimeUnit.SECONDS.sleep(3);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        int a = 10 / 1 ;
        return "执行完成";
    }
    public String getTimeoutHandler(){
        return "线程："+Thread.currentThread().getName()+"系统异常或其他错误";
    }
    public String getGlobalException(){
        return "global全局异常";
    }

    //===================服务熔断
    @HystrixCommand(fallbackMethod = "getFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少跳闸
    })
    public String getCircuitBreaker(Long id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数.....");
        }
        String s = IdUtil.randomUUID();
        return "调用正常,流水号是："+s;
    }
    public String getFallBack(@PathVariable("id") Long id){
        return "调用异常,id："+id;
    }
}
