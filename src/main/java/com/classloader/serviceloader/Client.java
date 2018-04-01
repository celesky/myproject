package com.classloader.serviceloader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ServiceLoader;

public class Client {
    public static void main(String[] args) throws Exception{
        ServiceLoader<ITestProvider> serviceLoader = ServiceLoader.load(ITestProvider.class);
        for(ITestProvider testProvider:serviceLoader){
            testProvider.hello();
        }



        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection ("","username","password");
//        //ClassLoader.loadClass()

        System.out.println(System.getProperty("jdbc.drivers"));
    }

}
