package com.classloader.test;

import com.classloader.myloader.MyClassLoaderNotOverride;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args)  throws Exception{
        ClassLoader diskLoader1 = new MyClassLoaderNotOverride("D:\\1");
        Class cls1 = null;
        try {
            //加载class文件
            cls1 = diskLoader1.loadClass("com.classloader.test.SpeakTest");
            System.out.println(cls1.getClassLoader().toString());
            if(cls1 != null){
                try {
                    Object obj = cls1.newInstance();
                    System.out.println("obj.getClass().getClassLoader() = " + obj.getClass().getClassLoader());

                    //SpeakTest1 speak = (SpeakTest1) obj;
                    //speak.speak();
                    Method method = cls1.getDeclaredMethod("speak",null);
                    //通过反射调用Test类的speak方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        MyClassLoaderNotOverride diskLoader = new MyClassLoaderNotOverride("D:\\2");
        System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader().toString());
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader().toString());

                // TODO Auto-generated method stub
                try {
                    //加载class文件
                     Thread.currentThread().setContextClassLoader(diskLoader);
                    //Class c = diskLoader.loadClass("com.frank.test.SpeakTest");
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    Class c = cl.loadClass("com.classloader.test.SpeakTest");
                    // Class c = Class.forName("com.frank.test.SpeakTest");
                    System.out.println(c.getClassLoader().toString());
                    if(c != null){
                        try {
                            Object obj = c.newInstance();
                            //SpeakTest1 speak = (SpeakTest1) obj;
                            //speak.speak();
                            Method method = c.getDeclaredMethod("speak",null);
                            //通过反射调用Test类的say方法
                            method.invoke(obj, null);
                        } catch (InstantiationException | IllegalAccessException
                                | NoSuchMethodException
                                | SecurityException |
                                IllegalArgumentException |
                                InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
