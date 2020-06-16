package com.syf.springcloud.dao;

import com.syf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.dao
 * @Author: syf
 * @Date: 2020/6/1 15:42
 * @Description:
 * @Version:
 */
@Mapper
public interface PaymentsDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
