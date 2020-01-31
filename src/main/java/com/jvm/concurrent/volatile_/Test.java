package com.jvm.concurrent.volatile_;

import java.util.concurrent.TimeUnit;

public class Test {



    public static void main(String[] args) throws Exception {
        ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
        longLocal.set(1234L);

    }
}
