package com.proxy.jdkproxy;

import com.proxy.jdkproxy.impl.BookFacadeImpl;
import com.proxy.jdkproxy.proxy.BookFacadeProxy;

/**
 * * cglib动态代理
 *1. 一个代理类就可以代理多个不同的被代理对象
 *2. 对于需要同样的增强代码，只需要在一个代理类中实现就可以。
 *
 * JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理，
 * cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，
 * 但因为采用的是继承，所以不能对final修饰的类进行代理。
 * @author Celes
 *
 */
public class TestJdkProxyDemo {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxyImpl = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxyImpl.addBook();

        //还可以代理其他的对象
//        MsgFacade msgProxyImpl = (MsgFacade) proxy.bind(new MsgFacadeImpl());
//        msgProxyImpl.sendMsg();

    }
}
