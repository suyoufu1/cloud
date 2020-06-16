package com.syf.springboot.redistest;

import com.syf.springcloud.utils.JedisUtils;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class RedisToString {
    @Test
    public void testString(){
        JedisUtils utils = new JedisUtils();
        Jedis jedis = utils.getJedis();
        String name = "syf";
        Boolean exists = jedis.exists("name");
        if(exists){
            System.out.println(" 进入redis... ");
            String vaule = jedis.get("name");
            System.out.println("vaule = " + vaule);
        }else {
            System.out.println("查询数据库...");
            jedis.set("name",name);
        }
        jedis.close();
    }
    @Test
    public void testHash(){
        JedisUtils utils = new JedisUtils();
        Jedis jedis = utils.getJedis();
        HashMap<String,String> hashMap = new HashMap<>();
        String name = "syf";
        String age = "22" ;
        hashMap.put("name",name);
        hashMap.put("age",age);
        Boolean users = jedis.exists("users");
        if(users){
            System.out.println(" 进入redis... ");
            Set<String> users1 = jedis.hkeys("users");
            for(String u : users1){
                System.out.println(u+"="+jedis.hget("users",u));
            }
        }else {
            System.out.println("进入数据库...");
            jedis.hmset("users",hashMap);
        }
    }
    @Test
    public void testHash2(){
        Jedis jedis = JedisUtils.getJedis();
        if(jedis.exists("users")){
            System.out.println("进入redis...");
            Map<String,String> map = jedis.hgetAll("users");
            System.out.println("map = " + map);
            for(String name : map.values()){
                System.out.println("name = " + name);
            }
        }else{
            System.out.println("进入数据库查找...");
            Map<String,String> map = new HashMap<>();
            map.put("name","syf");
            map.put("age","23");
            jedis.hmset("users",map);
        }
        System.out.println("jedis = " + jedis);
        jedis.close();
    }

    /**
     * 1.判断是否限制登录
     *  1.1 如果限制，则显示限制的等待时间
     *  2.1 如果没有限制
     *      3.判断
     */
    @Resource
    private static RedisTemplate template;
    public static String loginValidate(String u, String p){

        Jedis jedis = JedisUtils.getJedis();
        //用户登录失败的次数
        String keyLoginFail = "user:"+u+":login:fail:count";
        //用户禁止登录时间
        String keyLoginStop = "user:"+u+":login:stop:seconds";

        //总次数
        int num = 5 ;

        //如果用户禁止登录，返回等待的时间
        if(template.hasKey(keyLoginStop)){
            Long stopTime = template.getExpire(keyLoginStop, TimeUnit.MINUTES);
            return "因多次登录密码或者用户名输入错误，禁止登录"+stopTime+"分钟";
        }else { //如果用户可以登录
            //首次输入错误
            if(!template.hasKey(keyLoginFail)){
                //先设置值，在设置过期值
                jedis.set(keyLoginFail,"1");
                //设置过期值为两分钟
                template.expire(keyLoginFail, 2, TimeUnit.MINUTES);
                return "输入密码错误，在两分钟内还有"+(num-1)+"分钟输入的机会";
            }else {
                //查询登录次数
                Integer failCount = Integer.parseInt(jedis.get(keyLoginFail));
                if(failCount>=num-1){
                    //超过的登录的次数，禁止登录的时间为1小时
                    jedis.set(keyLoginStop,"1");
                    template.expire(keyLoginStop,1,TimeUnit.HOURS);
                    return "密码输入超过"+num+"次，禁止"+keyLoginStop+"小时";
                }else {//还没有到次数
                    //对其登录次数加一
                    jedis.incrBy(keyLoginFail,1);
                    Long seconds = template.getExpire(keyLoginFail, TimeUnit.SECONDS);
                    return "密码输入错误"+(failCount+1)+"次，在2分钟内还有"+(num-(failCount-1))+"次机会,还有"+seconds+"秒不能再输入，将禁止登录";
                }
            }
        }
    }

    public static void main(String[] args) {
        String validate = RedisToString.loginValidate("syf", "123456");
        System.out.println("validate = " + validate);
    }
}
