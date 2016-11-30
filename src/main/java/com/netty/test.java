package com.netty;

import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by pan on 16/8/31.
 */
public class test {
    public static void main(String[] args) {
        String s = "1234567a";
        Integer i=10012;
        try {
            byte[] bt = s.getBytes("UTF-8");
            //byte[] bt = i.getBytes("UTF-8");
            System.out.println("s.getBytes(\"UTF-8\") = " + s.getBytes("UTF-8"));
            System.out.println("bt.length = " + bt.length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ConcurrentHashMap map = new ConcurrentHashMap();

        System.out.println(1 >> 16);
    }
}
