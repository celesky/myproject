package com.jvm.concurrent.myfuture;

import java.util.concurrent.Callable;

public class TestMyFutrue {
    public static void main(String[] args) {
        FutrueTask<String> futrueTask = new FutrueTask<String>(new MyTask());
        Thread thread = new Thread(futrueTask);
        thread.start();
        System.out.println("开始等待future返回结果... " );
        String result = futrueTask.get();
        System.out.println("result = " + result);

        System.out.println("再重复获取一次结果："+futrueTask.get());
    }


    public static class MyTask implements Callable {

        @Override
        public String call() throws Exception {
            System.out.println("task is running started!........ ");
            Thread.sleep(2000);
            System.out.println("task is running finished!........ ");
            return "it ok now !";
        }
    }
}
