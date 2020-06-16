package com.syf.springcloud.service;

import com.syf.springcloud.dao.PaymentsDao;
import com.syf.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: cloud
 * @Package: com.syf.springcloud.service
 * @Author: syf
 * @Date: 2020/6/1 15:24
 * @Description:
 * @Version:
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource(name = "redisTemplate")
    HashOperations<String,Long,Object> hash;
    @Resource
    private PaymentsDao paymentDao;

    public Payment selectById(Long id){
        //查询缓存
        Payment payments = (Payment) hash.get("payments", id);
        if(null == payments){
            log.info(" ====查询数据库===== ");
            payments  = paymentDao.getPaymentById(id);
            hash.put("payments",id,payments);
        }
        return payments;
    }
}
