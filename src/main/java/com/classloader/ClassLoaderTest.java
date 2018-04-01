package com.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.DriverManager;

/**
 * 类加载器与instanceof关键字演示
 *
 * @author zzm
 */
public class ClassLoaderTest {
    public void justPrint(){
        System.out.println("just print hello world");
    }
    //自定义的classloader
    static ClassLoader myLoader = new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            try {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                throw new ClassNotFoundException(name);
            }
        }
    };

    /**
     * class对比
     * @throws Exception
     */
    public static void compare() throws Exception {
        //自定义的classloader载入的class,然后生成一个实例
        Object obj = myLoader.loadClass("com.classloader.TestGit").newInstance();
        System.out.println("obj.getClass().getClassLoader() = " + obj.getClass().getClassLoader());

        com.classloader.TestGit myloadObj = (TestGit)obj;
        System.out.println("myloadObj.getClass().getClassLoader() = " + myloadObj.getClass().getClassLoader());

        com.classloader.TestGit testObj = new com.classloader.TestGit();
        System.out.println("obj的loader是: " + obj.getClass().getClassLoader());
        System.out.println("testObj的loader是: " + testObj.getClass().getClassLoader());
        //和jvm自带类加载器appClassloader加载的类对比
        boolean is = obj instanceof  com.classloader.TestGit;
        //结果是false ,因为虽然是同一个class文件,但是他们是不同的类加载器载入的
        System.out.println("is = " + is);
    }

    /**
     * 测试反射
     * @throws Exception
     */
    public static void reflectInvokeTest() throws Exception{
        Class myclass = myLoader.loadClass("com.classloader.ClassLoaderTest");
        Object object = myclass.newInstance();
        Method method = myclass.getDeclaredMethod("justPrint");
        method.invoke(object);
    }

    public static void main(String[] args) throws Exception {
        compare();
//        reflectInvokeTest();
//        System.out.println("myLoader.getParent().getClass().getClassLoader() = " + myLoader.getParent().getClass().getClassLoader());
//
//
//        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "psw");


//        Object bookImpl = myLoader.loadClass("com.proxy.jdkproxy.impl.BookFacadeImpl").newInstance();
//        Object obj = myLoader.loadClass("com.classloader.TestGit").newInstance();
//
//        System.out.println("obj的loader是: " + obj.getClass().getClassLoader());
//        System.out.println("bookImpl的loader是: " + bookImpl.getClass().getClassLoader());

    }



}
