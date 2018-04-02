package com.jvm.concurrent.latch;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static CyclicBarrier cb = new CyclicBarrier(10);
    private static Random rnd = new Random();

    static class TaskDemo implements Runnable{
        private int id;
        TaskDemo(int id){
            this.id = id;
        }
        @Override
        public void run(){
            try {
                Thread.sleep(rnd.nextInt(1000));
                System.out.println("Thread " + id + " will wait");
                cb.await();//相当于自带countDown
                concurrentInvoke( id);
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException e) {
            }
        }
    }
    /**
     * 需要并发调用测试的业务方法
     */
    public static void concurrentInvoke(int id){
        System.out.println("-------Thread " + id + " is concurrent invoking!!!!!!");
    }

    public static void main(String[] args){
        CyclicBarrierDemo cbd = new CyclicBarrierDemo();
        for(int i=0;i<10;i++){
            new Thread(new TaskDemo(i)).start();
        }
    }
}