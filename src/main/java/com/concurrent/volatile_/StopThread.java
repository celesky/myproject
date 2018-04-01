package com.concurrent.volatile_;

import java.util.concurrent.TimeUnit;

/**
 * 用-server 模式运行
 * 如果不加volatile 会被jvm优化成如下这样
 * if (!stopRequested){
 *     while (true)
            i++;
 * }
 */
public class StopThread extends Thread{

    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                //这里不要加标准输出
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
