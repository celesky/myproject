package com.jvm.java8.forkjoin;

/**
 * Created by pan on 2018/1/29.
 */
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer>{

    private static final long serialVersionUID = 5550891835302602757L;

    private int start;
    private int end;
    private final int THREADCOUNT=50;
    /**
     * 构造方法
     * @param start 起始值
     * @param end 结束值
     */
    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }
    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool fjpool = new ForkJoinPool();
        CountTask ct = new CountTask(1, 100);
        ForkJoinTask<Integer> rt = fjpool.submit(ct);
        System.out.println(rt.get());
    }

    /**
     * 继承RecursiveTask类后需重写compute方法
     */
    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getId()+"_"+Thread.currentThread().getName());
        int sum=0;
        /*通过计算截止数据和起始数据之间的差值来判断是否需要对任务进行拆分，THREADCOUNT数值越小拆分的任务越多*/
        boolean recursion = end-start<=THREADCOUNT;
        if(recursion){
            for(int i=start; i<=end; i++){
                sum+=i;
            }
            return sum;
        }else{
            /*拆分任务*/
            //计算中间数据
            int model = (end+start)/2;
            CountTask leftTask = new CountTask(start, model);
            CountTask rightTask = new CountTask(model+1, end);
            leftTask.fork();
            rightTask.fork();
            int res1 = leftTask.join();
            int res2 = rightTask.join();
            sum=res2+res1;
        }
        return sum;
    }

}