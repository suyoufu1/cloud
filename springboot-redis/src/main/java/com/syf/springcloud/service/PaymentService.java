package com.syf.springcloud.service;

import com.syf.springcloud.dao.PaymentsDao;
import com.syf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/6/1 15:48
 * @Description:
 * @Version:
 */
@Service
public class PaymentService {
    @Resource
    private PaymentsDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getAllById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
