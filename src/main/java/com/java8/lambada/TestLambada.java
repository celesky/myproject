package com.java8.lambada;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 16/8/22.
 */
public class TestLambada {
    static FunctionalInterface functionalInterface;

    public static void runThreadWithLambada(){
        new Thread(()-> {
            System.out.println("thread begin...");
            System.out.println("heihei");
            }).start();
    }
    public static void runThreadUseInnerClass() {
        //这种方式就不多讲了，以前旧版本比较常见的做法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现的线程");
            }
        }).start();
    }
    public static void addPrint(FunctionalInterface fi){
        functionalInterface = fi;
    }
    public static void runPrint(String str,String name){
        functionalInterface.justPrint(str,name);
    }

    public static void operList(){
        List list = new ArrayList<String>();
        list.add("abc");
        list.add("efg");
        list.add("hij");

        //list.forEach(str-> System.out.println("str = " + str));
        list.forEach(System.out::println);
    }





    public static void main(String[] args) {
        TestLambada.runThreadWithLambada();

        TestLambada.addPrint((String str,String name)->{
            System.out.println(str+":"+name);
        });

        TestLambada.runPrint("hello ","jim");

        TestLambada.operList();
    }
}
