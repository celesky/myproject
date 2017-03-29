package com.flume;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by pan on 2017/3/11.
 */
public class Demo {
    private static Logger logger = LogManager.getLogger(Demo.class);
    public static void main(String[] args) throws InterruptedException {
        for(int i=1;i>0;i++){
            Thread.sleep(1500);
            logger.error("hello:"+i);
        }
    }

}
