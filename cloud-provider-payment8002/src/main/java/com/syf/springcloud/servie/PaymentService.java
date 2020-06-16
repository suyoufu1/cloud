package com.syf.springcloud.servie;

import com.syf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
