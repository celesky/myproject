package com.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by pan on 16/8/18.
 */
public class RedisUtil {
    static Jedis jedis;
    static{
        jedis = new Jedis("localhost",6379);
    }

    public void testString(){
        jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));//执行结果：xinxin
    }

    public static void main(String[] args){
        new RedisUtil().testString();
    }

}
