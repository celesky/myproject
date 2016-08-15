package com.proxy.staticproxy.proxy;

import com.proxy.staticproxy.BookFacade;

public class BookProxy implements BookFacade{
	private BookFacade bookFacade;  
	
	public BookProxy(BookFacade bookFacade){
		this.bookFacade = bookFacade;
	}
	
	
	@Override
	public void addBook() {
		 System.out.println("事务处理之前");  
	        // 调用委托类的方法;  
		 bookFacade.addBook();
		 
	     System.out.println("事务处理之后");  
	}

}
