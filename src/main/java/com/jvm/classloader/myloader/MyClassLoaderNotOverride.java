package com.jvm.classloader.myloader;

import com.jvm.classloader.myloader.MyClassLoader;

import java.io.*;

/**
 * 符合双亲委派模型的自定义classloader
 */
public class MyClassLoaderNotOverride  extends ClassLoader {

    private String mLibPath;

    public MyClassLoaderNotOverride(String path) {
        // TODO Auto-generated constructor stub
        mLibPath = path;
    }

//    /**
//     * 重写了loadClass，去掉了双亲委派模型逻辑
//     * 双亲委派模型的实现逻辑在父类 ClassLoader中
//     * 如果需要符合双亲模型，需要注释这个方法即可
//     * @param name
//     * @return
//     * @throws ClassNotFoundException
//     */
//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        try {
//            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
//            InputStream is = getClass().getResourceAsStream(fileName);
//            if (is == null) {
//                return super.loadClass(name);
//            }
//            byte[] b = new byte[is.available()];
//            is.read(b);
//            return defineClass(name, b, 0, b.length);
//        } catch (IOException e) {
//            throw new ClassNotFoundException(name);
//        }
//    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        String fileName = getFileName(name);

        File file = new File(mLibPath,fileName);

        try {
            FileInputStream is = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            try {
                while ((len = is.read()) != -1) {
                    bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = bos.toByteArray();
            is.close();
            bos.close();

            return defineClass(name,data,0,data.length);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    //获取要加载 的class文件名
    private String getFileName(String name) {
        // TODO Auto-generated method stub
        int index = name.lastIndexOf('.');
        if(index == -1){
            return name+".class";
        }else{
            return name.substring(index+1)+".class";
        }
    }

    public static void main(String[] args) throws Exception {
        Object bookImpl = new MyClassLoader("").loadClass("com.proxy.jdkproxy.impl.BookFacadeImpl").newInstance();
        Object obj =  new MyClassLoader("").loadClass("com.classloader.TestGit").newInstance();

        System.out.println("obj的loader是: " + obj.getClass().getClassLoader());
        System.out.println("bookImpl的loader是: " + bookImpl.getClass().getClassLoader());
    }
}
