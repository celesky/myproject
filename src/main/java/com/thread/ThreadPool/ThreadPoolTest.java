package com.thread.ThreadPool;

import java.util.concurrent.*;

/**
 * Created by pan on 2018/1/28.
 */
public class ThreadPoolTest {
    public void init(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int i=0;
        while (true){
            Future<Boolean> future;
            if(i%5==1){
                future = executorService.submit(new ErrTask());
            }else{
                future = executorService.submit(new MyTask());
            }

            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    static class MyTask implements Callable<Boolean>{

        @Override
        public Boolean call() {

            System.out.println("ok Thread is executing " + Thread.currentThread().getId()+"|"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    static class ErrTask implements Callable<Boolean>{

        @Override
        public Boolean call() {
            System.out.println("error Thread is executing " + Thread.currentThread().getId()+"|"+Thread.currentThread().getName());
            int i=1/0;
            return false;
        }
    }

    public static void main(String[] args) {
        new ThreadPoolTest().init();
    }
}
