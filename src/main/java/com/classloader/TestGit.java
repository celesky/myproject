package com.classloader;


import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by pan on 16/11/28.
 */
public class TestGit {
    static{
        System.out.println("TestGit类被初始化了");
    }
    {
        System.out.println("静态代码块");
    }
    public static String s = getString();

    private static String getString() {
        System.out.println("给静态变量赋值的静态方法执行：loading line");
        return "ss";
    }

    public TestGit(){
        System.out.println("构造方法....");
    }
    public static void main(String[] args) throws Exception{
        System.out.println("sun.boot.class.path>>>>>>>>>>>>>>");
        //Splitter.on(";").split(System.getProperty("sun.boot.class.path")).forEach(System.out::println);
        System.out.println("java.ext.dirs>>>>>>>>>>>>>> ");
        //Splitter.on(";").split(System.getProperty("java.ext.dirs")).forEach(System.out::println);;
        System.out.println("java.class.path>>>>>>>>>>>>>> = ");
        //Splitter.on(";").split(System.getProperty("java.class.path")).forEach(System.out::println);
//
//        System.out.println(TestGit.class.getClassLoader());//appCL加载的类
//        System.out.println(HashMap.class.getClassLoader());//bootstrap加载的类
//        System.out.println(com.sun.nio.zipfs.ZipFileStore.class.getClassLoader());//extention 加载的类
//
//        ClassLoader diskLoader1 = new MyTestClassLoader("D:\\1");
//        Class speakClass = diskLoader1.loadClass("com.classloader.test.SpeakTest");
//        System.out.println("speakTestObj clasloader:"+speakClass.getClassLoader());
//
//        Object obj = speakClass.newInstance();
//        System.out.println("obj.getClass().getClassLoader() = " + obj.getClass().getClassLoader());
//
//        //SpeakTest1 speak = (SpeakTest1) obj;
//        //speak.speak();
//        Method method = speakClass.getDeclaredMethod("speak",null);
//        //通过反射调用Test类的speak方法
//        method.invoke(obj, null);
//
//        Class cl = Class.forName("com.classloader.test.SpeakTest");
//        System.out.println("cl = " + cl.getClassLoader());
//        Class c2 = Class.forName("com.classloader.test.SpeakTest",true,diskLoader1);
//        System.out.println("c2 = " + c2.getClassLoader());

        String s3 = "ssssss";
        System.out.println(s3.intern() == s3);
        String s4 = new String("ssssss");
        System.out.println(s4.intern() == s3);



//        String str1 = new StringBuilder("chaofan").append("wei").toString();
//        System.out.println(str1.intern() == str1);
//
//        System.out.println(s3.intern() == str1.intern());
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);

    }
}
