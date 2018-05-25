package com.alibaba;

import java.util.function.BiFunction;

public class Test {
    static int x = 10;
    static {
        x += 5;
    }
    public static void main(String[] args){
        System.out.println("x= "+ x);
    }
    static {
        x += 3;
    }
}

class Cars {
    static {
        System.out.println("static");
    }
    private static void drive() {
        System.out.println("fast");
    }
    public static void main(String[] args) {
        System.out.println(1234%10);
        int x =  reverseInt(1234);
        System.out.println(x);
    }

    public static int reverseInt(int x) {
        int data = 0;
        while (x != 0) {
            int temp = data * 10 + x % 10;
            x = x / 10;
            if (temp / 10 != data) {
                data = 0;
                break;
            }
            data = temp;
        }
        return data;
    }
}

