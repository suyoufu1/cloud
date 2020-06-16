package com.syf.springcloud.servie.impl;

import com.syf.springcloud.dao.PaymentDao;
import com.syf.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.servie.impl
 * @Author: syf
 * @Date: 2020/6/1 16:46
 * @Description:
 * @Version:
 */
@Service
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    HashOperations<String,Long,Object> hash;
    @Resource
    private PaymentDao paymentDao;

    public Payment selectById(Long id){
        //查询缓存
        Payment payments = (Payment) hash.get("payments", id);
        if(null == payments){
            System.out.println(" ====查询数据库===== ");
            payments  = paymentDao.getPaymentById(id);
            hash.put("payments",id,payments);
        }
        return payments;
    }
}
