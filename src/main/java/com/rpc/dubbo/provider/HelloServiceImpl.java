package com.rpc.dubbo.provider;


import com.rpc.dubbo.api.HelloServiceProvider;

public class HelloServiceImpl implements HelloServiceProvider {
    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public String goodBye() {
        return "goodBye";
    }
}
