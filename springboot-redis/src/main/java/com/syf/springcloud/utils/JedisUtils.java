package com.syf.springcloud.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static final JedisPool  JEDIS_POOL;
    //配置jedis连接池
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(10000);
        JEDIS_POOL = new JedisPool(config,"localhost",6021);
    }
    //获取jedis连接池中资源信息
    public static Jedis getJedis(){
        Jedis jedis = JEDIS_POOL.getResource();
        return jedis;
    }
}
