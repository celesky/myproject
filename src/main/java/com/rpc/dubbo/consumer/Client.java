package com.rpc.dubbo.consumer;

import com.caucho.hessian.client.HessianProxyFactory;
import com.rpc.dubbo.api.HelloServiceProvider;

public class Client {
    public static void main(String[] args) throws Exception {
        String serviceUrl = "http://192.168.10.189:20883/com.rpc.dubbo.api.HelloServiceProvider$";
        HessianProxyFactory factory = new HessianProxyFactory();

        HelloServiceProvider userService = (HelloServiceProvider) factory.create(HelloServiceProvider.class, serviceUrl);
        String result = userService.hello();
        System.out.println(result);


    }
}
