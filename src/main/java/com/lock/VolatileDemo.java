package com.lock;

public class VolatileDemo extends Thread {
    //设置类静态变量,各线程访问这同一共享变量
    private volatile boolean flag = false;

    //无限循环,等待flag变为true时才跳出循环
    public void run() {
        while (!flag) {
            System.out.println("循环执行中....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ;

    }

    public static void main(String[] args) throws Exception {
        VolatileDemo demo = new VolatileDemo();
        demo.start();
        //sleep的目的是等待线程启动完毕,也就是说进入run的无限循环体了
        Thread.sleep(5000);
        demo.flag = true;

    }
//      public void test(){
//    	  ReentrantLock rl =  new ReentrantLock();
//  		  rl.lock();
//  		  AtomicReference<Integer> ar = new AtomicReference<Integer>();
//  		  ar.compareAndSet(1, 2);
//  		  
//  		  System.out.println(11);
//      }

}
