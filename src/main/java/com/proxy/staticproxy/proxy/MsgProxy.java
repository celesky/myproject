package com.proxy.staticproxy.proxy;

import com.proxy.staticproxy.MsgFacade;

public class MsgProxy implements MsgFacade{
	private MsgFacade msgFacade;

	public MsgProxy(MsgFacade msgFacade){
		this.msgFacade = msgFacade;
	}


	@Override
	public void sendMsg() {
		System.out.println("事务处理之前");
		// 调用委托类的方法;
		msgFacade.sendMsg();

		System.out.println("事务处理之后");
	}

}
