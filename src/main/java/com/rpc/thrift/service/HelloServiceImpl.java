package com.rpc.thrift.service;

import com.rpc.thrift.api.HelloService;

public class HelloServiceImpl implements HelloService.Iface {
    public String hello(String name) {
        return "hello : "+name;
    }
}
