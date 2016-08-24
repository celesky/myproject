package com.lock;

public class ModThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("给他催眠中，设置asleep=false");
            LockDemo.asleep = false;
        }
    }

}
