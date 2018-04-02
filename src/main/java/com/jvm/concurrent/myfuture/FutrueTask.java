package com.jvm.concurrent.myfuture;


import java.util.concurrent.*;

/**
 * 自己实现的futrureTask
 * @param <T>
 */
public class FutrueTask<T> implements Runnable,Future<T>{

    //volatile Thread runner;

    //用来确保任务只会执行一次
    volatile boolean ran=false;

    //需要执行的实际任务
    Callable<T> callable;

    //返回结果
    T result;


    public FutrueTask(Callable<T> callableTask){
        callable = callableTask;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    public T get() {
        try {
            if(!ran){
                synchronized (this){
                    this.wait();
                }
            }
            return result;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void run()  {
        //执行任务
        try {
            result = callable.call();
            ran=true;
        } catch (Exception e) {
            e.printStackTrace();
            ran=true;
        }
        synchronized (this){
            this.notify();
        }

    }
}
