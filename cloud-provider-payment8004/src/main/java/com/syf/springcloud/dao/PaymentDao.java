package com.syf.springcloud.dao;


import com.syf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.dao
 * @Author: syf
 * @Date: 2020/5/17 14:26
 * @Description: payment连接数据源接口
 * @Version:
 */

@Mapper
public interface PaymentDao {

    public Payment getPaymentById(@Param("id") Long id);

    public int create(Payment payment);
}
