package com.disruptor;

/**
 * i=10
 * 即10个线程 和 长度为10的数组
 * 每个线程负责对对应下表的数组元素进行5000万次赋值操作
 */
public class FalseSharingPadding implements Runnable{
    public final static long ITERATIONS = 500L * 1000L * 100L;
    private int arrayIndex = 0;

    private static ValuePadding[] valueArrays;

    public FalseSharingPadding(final int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(final String[] args) throws Exception {
        for(int i=1;i<10;i++){
            System.gc();
            final long start = System.currentTimeMillis();
            runTest(i);
            System.out.println("Thread num "+i+" duration = " + (System.currentTimeMillis() - start));
        }

    }

    private static void runTest(int NUM_THREADS) throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        valueArrays = new ValuePadding[NUM_THREADS];
        for (int i = 0; i < valueArrays.length; i++) {
            valueArrays[i] = new ValuePadding();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharingPadding(i));
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            valueArrays[arrayIndex].value = 0L;
        }
    }

    public final static class ValuePadding {
        //protected long p1, p2, p3, p4;
        protected volatile long value = 0L;
        //protected long p9, p10, p11;
    }

}