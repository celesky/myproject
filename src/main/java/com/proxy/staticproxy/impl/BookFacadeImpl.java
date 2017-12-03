package com.proxy.staticproxy.impl;

import com.proxy.staticproxy.BookFacade;

/**
 * 书籍操作实现类
 * 被代理对象
 * @author Celes
 *
 */
public class BookFacadeImpl implements BookFacade{

	@Override
	public void addBook() {
		System.out.println("增加图书的普通方法...");
	}

}
