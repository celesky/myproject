package com.java8.lambada.action._2;

public class Test {

    public static void doSomething(Runnable r){ r.run(); }
    public static void doSomething(Task a){ a.execute(); }

    public static void main(String[] args) {
        doSomething((Task) ()->System.out.println("x"));
    }
}
