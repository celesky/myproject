package com.rpc.dubbo.provider.impl;

import com.rpc.dubbo.api.dthrift.ThriftApiProvider;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service("thriftApiService")
public class ThriftApiServiceImpl implements ThriftApiProvider.Iface {
    @Override
    public String hello(String name) throws TException {
        return "你好，"+name+",这是一条通过thrift协议传输的消息！";
    }
}
