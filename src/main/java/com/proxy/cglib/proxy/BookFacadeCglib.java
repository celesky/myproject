package com.proxy.cglib.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 代理类
 * 可以增强被代理的对象的行为
 * @author Celes
 *
 */
public class BookFacadeCglib implements MethodInterceptor  {

	private Object target;

	/**
	 * 创建代理对象
	 *
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	// 回调方法
	public Object intercept(Object obj, Method method, Object[] args,
							MethodProxy proxy) throws Throwable {
		System.out.println("事物开始");
		proxy.invokeSuper(obj, args);
		System.out.println("事物结束");
		return null;
	}

}
