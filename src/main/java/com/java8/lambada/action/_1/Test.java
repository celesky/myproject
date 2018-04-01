package com.java8.lambada.action._1;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 参数化行为测试
 */
public class Test {

    /**
     * Predicate<Apple> p 参数化行为
     *
     * @param inventory
     * @param p
     * @return
     */
    static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> p) {
        List<Apple> applesList = new ArrayList<>();
        for(Apple apple:inventory){
            if(p.test(apple)){
                applesList.add(apple);
            }
        }
        return applesList;
    }

    /**
     *
     * Predicate<Apple> p 参数化行为
     * 泛化后版本
     * @param p
     * @return
     */
    static <T> List<T> filter(List<T> list,Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T e:list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }


    static List<Apple> getList(){
        Apple apple = new Apple(1,"green");
        Apple apple2 = new Apple(6,"red");
        Apple apple3 = new Apple(7,"green");

        List<Apple> inventory = new ArrayList<>();
        inventory.add(apple);
        inventory.add(apple2);
        inventory.add(apple3);
        return inventory;
    }


    public static void main(String[] args) {
        List<Apple> inventory =  getList();
        //过滤
        /**
         *  1.一个匿名类实现了 Predicate接口
         *  2. Apple.isApple() 作为test方法的重写实现
         */
        List<Apple> list2 = filterApples(inventory,new Predicate<Apple>(){
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight()>5;
            }
        });


        list2.stream().collect(Collectors.toList() );
        List<Apple> list = filterApples(inventory,Apple::isBig);


        List<Integer> intList = Arrays.asList(3,2,6,7);
        String s = intList.stream().map(String::valueOf).collect(Collectors.joining(","));
        intList.stream().collect(Collectors.reducing((a,b)->a>b?a:b));

        System.out.println("s = " + s);

        List big5List = filter(intList,e-> e>5);

        list.forEach(System.out::println);
        list.forEach(e->System.out.println(e));

        Predicate<Apple> p = (Apple a) -> a.getWeight()>0;
        Predicate<Apple> p2 = p.negate().and(e->e.isBig()).or(e->e.isGreen());

       inventory.stream().filter(p2).forEach(System.out::println);
        intList.stream().reduce(0,(a,b)->a+b);
        intList.stream().reduce(0,Integer::sum);
    }


}
