package com.syf.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/5/25 15:10
 * @Description:
 * @Version:
 */
@Component
public class PaymentFallBackHystrix implements PaymentHystrixService {
    @Override
    public String getThread(Long id) {
        String s = "出现了异常：getThread";
        return s;
    }

    @Override
    public String getTimeOutThread() {
        return "出现了异常：getTimeOutThread";
    }
}
