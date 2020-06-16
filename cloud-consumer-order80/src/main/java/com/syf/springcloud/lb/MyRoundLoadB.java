package com.syf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.lb
 * @Author: syf
 * @Date: 2020/5/18 15:37
 * @Description: 负载均衡算法-轮询算法
 * @Version:
 */
@Component
public class MyRoundLoadB implements LB {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * current: 当前次数
     * next: 下一次
     * 用CAS来保证原子性
     * @return
     */
    private final int getAndIncrement(){
        int current ;
        int next ;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE  ? 0 : current + 1;

        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next = " + next);
        return next;
    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        //求余获取服务器节点的索引
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
