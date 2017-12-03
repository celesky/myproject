package com.thread.threadLocal;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pan on 16/9/9.
 * 内存溢出demo
 */
public class ThreadLocalOOM {
    public static void main(String[] args) {
        new ThreadLocalOOM().exe();
    }

    public void exe(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new MyTask());
        System.gc();
    }

    class MyTask implements Runnable{
        ThreadLocal<byte[]> tl = new ThreadLocal<byte[]>();

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("now set 30m");
                tl.set(new byte[1024*1024*30]);
                Thread.sleep(5000);
                System.out.println("now clear");
                tl.set(null);
                System.gc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
