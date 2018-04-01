package com.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pan on 16/8/18.
 */
public class RedisUtil {
    static Jedis jedis;

    static {
        jedis = new Jedis("139.196.151.78", 6377);
    }

    public static void testString() {
        jedis.set("justname", "xinxin");
        System.out.println(jedis.get("justname"));
    }
    public static void testSetHash(){
        jedis.hset("product:5001","productId","2006101010101");
        jedis.hset("product:5001","productNo","2093801010101");
        jedis.hset("product:5001","picUrl","www.shop.com/0801/111.jpg");
        jedis.hset("product:5001","productName","Iphone 5s");
        jedis.hset("product:5001","price","5000.00");
        jedis.hset("product:5001","stockNum","400");

        jedis.hset("product:5002","productId","2006101010102");
        jedis.hset("product:5002","productNo","2093801010102");
        jedis.hset("product:5002","picUrl","www.shop.com/0801/222.jpg");
        jedis.hset("product:5002","productName","Iphone se");
        jedis.hset("product:5002","price","4000.00");
        jedis.hset("product:5002","stockNum","400");

    }

    public static void testReadHash(){
        Map product = jedis.hgetAll("product:5002");
        System.out.println(product.get("productName"));

        String price = jedis.hget("product:5001","price");
        System.out.println("price = " + price);
    }


    public static void testList(){
        jedis.rpush("productIds","5010");
        jedis.rpush("productIds","5011");
        jedis.rpush("productIds","5012");
        jedis.rpush("productIds","5013");
        jedis.lpush("productIds","5014");


        System.out.println(jedis.lrange("productIds",1,10));
    }

    public static void testZHash(){
        jedis.zadd("productPrices:5001",100,"oldPrice");
        jedis.zadd("productPrices:5001",90,"discoutPrice");
        jedis.zadd("productPrices:5001",80,"newPrice");
        jedis.zadd("productPrices:5001",60,"vipPrice");
        //Set set = jedis.zrange("productPrices:5001",1,3);
        Set set = jedis.zrangeByScore("productPrices:5001",60,80);
        System.out.println(set);
    }

    public static void main(String[] args) {

        RedisUtil.testString();
//        //RedisUtil.testSetHash();
//        //RedisUtil.testReadHash();
//        //testList();
//        //testZHash();
//        try {
//            System.out.println(123456);
//            Thread.sleep(600000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

}
