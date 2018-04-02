package com.jvm.thread.threadLocal;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pan on 16/9/9.
 * 内存溢出demo
 */
public class ThreadLocalOOM {
    public static void main(String[] args) {
        new ThreadLocalOOM().exe();
        URI.create("https://hezuo.lifesense.com/raw/common/third_party_login_account.html?name=Smart%20Home");

    }

    public void exe(){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new MyTask());
        System.gc();
    }

    class MyTask implements Runnable{
        ThreadLocal<byte[]> threadLocal1 = new ThreadLocal<byte[]>();
        ThreadLocal<byte[]> threadLocal2 = new ThreadLocal<byte[]>();
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("now set 30m");
                threadLocal1.set(new byte[1024*1024*30]);
                threadLocal2.set(new byte[1024*1024*30*10]);
                Thread.sleep(5000);
                System.out.println("now clear");
                threadLocal1.set(null);
                threadLocal2.get();
                System.gc();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
