package com.classloader.warmdeploy;

import com.classloader.myloader.MyClassLoader;
import com.classloader.test.ISpeak;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class WarmDeployTool {
    final static String classPath = "D:\\2";
    static MyClassLoader myloader ;
    static Class cls;

    public static void warmDeploy(){
        try {
            int i=1;
            while(true){
                System.out.println("\n");
                System.out.println("----------------------------------------------------------");
                System.out.println("WarmDeployTool deploytask 开始进行第 "+(i)+" 次热部署...");
                myloader = new MyClassLoader(classPath);
                cls = myloader.loadClass("com.classloader.test.SpeakTest");
                System.out.println("WarmDeployTool deploytask 第 "+(i)+" 次热部署完成...");
                System.out.println("----------------------------------------------------------\n");
                i++;
                //System.out.println("classloader:"+cls.getClassLoader());
                Thread.sleep(4000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 该任务不停的从目录里面重新加载class文件
     */
    static class deployTask implements Runnable{

        @Override
        public void run() {
            warmDeploy();
        }
    }


    /**
     * 该任务不停的通过反射调用类的对象方法
     * 模拟使用方
     */
    static class worker implements Runnable{
        @Override
        public void run() {
            try {
                int i=1;
                while(true){
                    if(cls!=null){
                        //System.out.println(">>>>>>>>>>>>>>>>worker开始反射调用了。。。。。:"+i);
                        Object obj = cls.newInstance();

                        Method[] methods = cls.getDeclaredMethods();
                        Arrays.asList(methods).forEach(method->{
                            try {
                                method.invoke(obj,null);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
                        //System.out.println(">>>>>>>>>>>>>>>>worker反射调用完成了。。。。。:"+i);
                        i++;
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * 该任务不停的通过反射调用类的对象方法
     * 模拟使用方
     */
    static class workerNew implements Runnable{
        @Override
        public void run() {
            try {
                int i=1;
                while(true){
                    if(cls!=null){
                        //System.out.println(">>>>>>>>>>>>>>>>worker开始反射调用了。。。。。:"+i);
                        ISpeak obj = (ISpeak)cls.newInstance();

                        obj.speak();
                        //System.out.println(">>>>>>>>>>>>>>>>worker反射调用完成了。。。。。:"+i);
                        i++;
                    }
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //启动热加载线程
        new Thread(new deployTask()).start();
        //启动应用线程
        new Thread(new workerNew()).start();


    }

}
