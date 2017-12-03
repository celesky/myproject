package com.proxy.cglib;

import com.proxy.cglib.byproxy.BookFacadeImpl;
import com.proxy.cglib.byproxy.MsgFacadeImpl;
import com.proxy.cglib.proxy.BookFacadeCglib;

/**
 * cglib动态代理
 *1. 一个代理类就可以代理多个不同的被代理对象
 *2. 对于需要同样的增强代码，只需要在一个代理类中实现就可以。
 *
 * JDK的动态代理机制只能代理实现了接口的类，而不能实现接口的类就不能实现JDK的动态代理，
 * cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，
 * 但因为采用的是继承，所以不能对final修饰的类进行代理。
 * @author Celes
 *
 */
public class TestCglibDemo {

	public static void main(String[] args) {
		//new一个代理类
		BookFacadeCglib cglib=new BookFacadeCglib();
		//生成代理之后的bookimpl
		BookFacadeImpl bookProxyImpl=(BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());
		bookProxyImpl.addBook();
		bookProxyImpl.delBook();
		//生成代理之后的msgImpl
		MsgFacadeImpl msgProxyImpl=(MsgFacadeImpl)cglib.getInstance(new MsgFacadeImpl());
		msgProxyImpl.sendMsg();
	}
}
