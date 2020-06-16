package com.syf.springcloud.servie.impl;

import com.syf.springcloud.entities.Payment;
import com.syf.springcloud.dao.PaymentDao;
import com.syf.springcloud.servie.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
