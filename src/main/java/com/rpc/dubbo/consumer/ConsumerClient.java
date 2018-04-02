package com.rpc.dubbo.consumer;

import com.rpc.dubbo.api.HelloServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsumerClient {

    @Autowired
    HelloServiceProvider helloService;

    public void test(){
        System.out.println("message from helloservice:" + helloService.hello());
    }


    public static void main(String[] args) {

    }
}
