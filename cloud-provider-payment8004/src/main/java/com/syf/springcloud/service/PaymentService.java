package com.syf.springcloud.service;

import com.syf.springcloud.entities.Payment;
import com.syf.springcloud.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/5/17 14:35
 * @Description: 业务处理层
 * @Version: 1.0
 */

@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        int result = paymentDao.create(payment);
        return result;
    }
    public Payment getPaymentById(Long id){
        Payment payment = paymentDao.getPaymentById(id);
        return payment;
    }
}
