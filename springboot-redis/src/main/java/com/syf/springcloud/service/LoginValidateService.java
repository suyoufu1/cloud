package com.syf.springcloud.service;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class LoginValidateService {
    @Resource
    private RedisTemplate template;
    /**
     * 1.判断当前用户是否被限制
     */
    public Map<String,String> loginUserLock(String uname){

        return null;
    }
}
