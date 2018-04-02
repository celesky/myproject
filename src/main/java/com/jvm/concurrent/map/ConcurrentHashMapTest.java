package com.jvm.concurrent.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap(16);
        String value = map.putIfAbsent("111","111");
        System.out.println(value);
        String value2  = map.putIfAbsent("111","111");
        System.out.println(value2);
        String value3  = map.putIfAbsent("111","112");
        System.out.println(value3);
        System.out.println("map.get(\"111\") = " + map.get("111"));
    }
}
