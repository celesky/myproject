package com.jvm.classloader.serviceloader;

public class Test1Impl implements ITestProvider {
    @Override
    public void hello() {
        System.out.println(" hello! this is Test1Impl ");
    }
}
