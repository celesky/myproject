package com.classloader.serviceloader;

public class Test2Impl implements ITestProvider{
    @Override
    public void hello() {
        System.out.println(" hello! this is Test2Impl ");
    }
}
