package com.concurrent.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Client {
    public static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavoriteShop"),
            new Shop("BuyItAll"));





    public static void doSomethingElse(){
        System.out.println("now do something else..!");
    }
    public static void test(){
        long start = System.nanoTime();
        Future<Double> futurePrice = Shop.getPriceAsync2("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");
        // 执行更多任务，比如查询其他商店
        doSomethingElse();
        // 在计算商品价格的同时
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    public static void main(String[] args) {


    }
}
