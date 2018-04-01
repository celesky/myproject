package com.concurrent.futrue;

import java.util.concurrent.*;

public class TestFuture {
    //static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws Exception  {
        FutureTask<String> futureTask = new FutureTask(new MyTask());
        new Thread(futureTask).start();
        System.out.println("now waiting for future.get() ");
        String result = (String) futureTask.get();
        System.out.println("get result:"+result);
    }


    public static class MyTask implements Callable{

        @Override
        public String call() throws Exception {
            System.out.println("task is running!........ ");
            Thread.sleep(2000);
            System.out.println("task is running ok!........ ");
            return "it ok now !";
        }
    }

}
