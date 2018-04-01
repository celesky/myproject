package com.concurrent.completablefuture;

import java.util.Random;
import java.util.concurrent.*;

public class Shop {
    private final static Executor executor =
            Executors.newFixedThreadPool(Math.min(Client.shops.size(), 100),
                    new ThreadFactory() {
                        public Thread newThread(Runnable r) {
                            Thread t = new Thread(r);
                            t.setDaemon(true);
                            return t;
                        }
                    });

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread( () -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();
        return futurePrice;
    }

    /**
     * lambda
     * @param product
     * @return
     */
    public static Future<Double> getPriceAsync2(String product){
        CompletableFuture future =  CompletableFuture.supplyAsync(()->calculatePrice(product));
        return future;
    }

    /**
     * 传入线程池
     * @param product
     * @return
     */
    public static Future<Double> getPriceAsync3(String product){
        CompletableFuture future =  CompletableFuture.supplyAsync(()->calculatePrice(product),executor);
        return future;
    }
    public static Double calculatePrice(String product){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        if(1==1){
//            throw new RuntimeException("fucking you !");
//        }
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
