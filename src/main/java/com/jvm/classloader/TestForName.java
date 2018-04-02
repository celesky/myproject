package com.jvm.classloader;


import com.jvm.classloader.myloader.MyClassLoader;

public class TestForName {
    public static void main(String[] args) throws Exception {
//        ClassLoader classLoader = new MyClassLoader("");
//        Class cls = classLoader.loadClass("com.jvm.classloader.TestGit");
//        System.out.println("cls.getClassLoader() = " + cls.getClassLoader());
//        Class cl = Class.forName("com.jvm.classloader.TestGit");
//        System.out.println("cl = " + cl.getClassLoader());
        Class c2 = Class.forName("com.jvm.classloader.TestGit",true,TestForName.class.getClassLoader());
        TestGit testGit =  (TestGit)c2.newInstance();

        System.out.println("c2 = " + c2.getClassLoader());
    }
}
