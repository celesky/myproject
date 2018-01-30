package com.concurrent;
import java.util.concurrent.CountDownLatch;

/**
 * Created by pan on 2018/1/29.
 */
public class CountDownLatchDemo {

    private static CountDownLatch latch = new CountDownLatch(10);

    static class TaskDemo implements Runnable{
        private int id;
        TaskDemo(int id){
            this.id = id;
        }
        @Override
        public void run(){
            try {
                System.out.println("Thread " + id + " will wait");
                latch.await();
                concurrentInvoke(id);

            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * 需要并发调用测试的业务方法
     */
    public static void concurrentInvoke(int id){
        System.out.println("-------Thread " + id + " is concurrent invoking!!!!!!");
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(new TaskDemo(i)).start();
            latch.countDown();
        }
    }
}
