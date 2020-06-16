package com.syf.springcloud.lb;

import org.apache.catalina.util.ServerInfo;
import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.lb
 * @Author: syf
 * @Date: 2020/5/18 15:39
 * @Description: 接口提高获取服务节点方法
 * @Version:
 */
public interface LB {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
