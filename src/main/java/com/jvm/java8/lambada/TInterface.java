package com.jvm.java8.lambada;

/**
 * Created by pan on 16/9/28.
 */
public interface TInterface  {
    public  void gennerate(String[]... str);
    public  void gennerate(String[] str);
    static void fuck(){
        throw new RuntimeException("");
    }
}
