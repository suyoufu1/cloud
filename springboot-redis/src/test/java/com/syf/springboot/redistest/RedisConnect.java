package com.syf.springboot.redistest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnect {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost",6021);
        Long append = jedis.append("hello", "world");
        System.out.println("append = " + append);
        //redis权限认证
        jedis.auth("");
    }

    //创建redis连接池
    public void test2(){
        //redis连接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(1000);
        //redis连接池
        JedisPool jedisPool = new JedisPool(config,"localhost",6021);
        Jedis jedis = jedisPool.getResource();//在连接池中得到资源
        jedis.close();


    }
}
