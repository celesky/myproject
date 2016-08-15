package com.proxy.staticproxy;

import com.proxy.staticproxy.impl.BookFacadeImpl;
import com.proxy.staticproxy.impl.MsgFacadeImpl;
import com.proxy.staticproxy.proxy.BookProxy;
import com.proxy.staticproxy.proxy.MsgProxy;

/**
 * 静态代理 ，代理类和被代理对象 需要继承自同一个接口
 *  	       不同的被代理对象 需要给他创建对应的代理对象，也就是 一个代理类只能代理一个接口
 *         如果需要增强的功能代码都是一样的，这就会造成大量的重复代码
 *         
 *  而动态代理，只需要一个代理类就可以代理多个不同的接口
 * @author Celes
 *
 */
public class TestSProxyDemo {
	
	 public static void main(String[] args) {  
		 //new一个被代理类
		 BookFacade bookFacade = new BookFacadeImpl();
		 //new一个代理类
		 BookProxy bookProxy = new BookProxy(bookFacade);
		 //执行
		 bookProxy.addBook();
		 
		 //new一个被代理类
		 MsgFacade msgFacadeImpl = new MsgFacadeImpl();
		 //new一个代理类
		 MsgProxy msgProxy = new MsgProxy(msgFacadeImpl);
		 //执行
		 msgProxy.sendMsg();
	 }
}
