package com.proxy.cglib.byproxy;

/**
 * 被代理类  用cglib无需实现接口
 * @author Celes
 *
 */
public class BookFacadeImpl {

	public void addBook() {
		System.out.println("增加图书的普通方法...");
	}

	public void delBook() {
		System.out.println("删除图书的普通方法...");
	}
}
