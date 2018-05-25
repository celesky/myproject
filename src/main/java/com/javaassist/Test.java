package com.javaassist;

import javassist.ClassPool;
import javassist.CtClass;

import java.util.Arrays;

public class Test {

    public static void main(String[] args)throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass =  classPool.get("com.alibaba.OrderEntity");

        byte[] bytes = ctClass.toBytecode();
        System.out.println("Arrays.toString(bytes) = " + Arrays.toString(bytes));

        System.out.println("ctClass = " + ctClass.getName());
        System.out.println("ctClass = " + ctClass.getSimpleName());
        System.out.println("ctClass = " + ctClass.getInterfaces());
    }
}
