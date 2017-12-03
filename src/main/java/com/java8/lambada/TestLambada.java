package com.java8.lambada;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        list.forEach(p->System.out.println(p));
    }

    public static void reduce(){
        String[] caloris = {"1","2","3","4","5","6","0","0","7"};//.forEach(System.out::println)
        //Stream.of(caloris).map(x->Integer.parseInt(x) ).filter(x->x>0).collect(Collectors.toList()).stream().forEach(System.out::println);
        //Object aa = Stream.of(caloris).map(x->Integer.parseInt(x) ).filter(x->x>0).reduce(0,(result,element)->result=result+element).get();
        Stream.of(caloris).map(x->Integer.parseInt(x) ).filter(x->x>0).reduce((result, element)->result=result+element);
        //Stream.of(caloris).collect(Collectors.toList()).stream().mapToInt(e->e.)
        //System.out.println("aa = " + aa);
    }



    public static void main(String[] args) {
        TestLambada.runThreadWithLambada();

        TestLambada.addPrint((String str,String name)->{
            System.out.println(str+":"+name);
        });

        TestLambada.runPrint("hello ","你大爷");

        TestLambada.operList();
    }
}
