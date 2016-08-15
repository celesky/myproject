package com.proxy.staticproxy.impl;

import com.proxy.staticproxy.MsgFacade;

public class MsgFacadeImpl implements MsgFacade{

	@Override
	public void sendMsg() {
		System.out.println("发送消息的普通方法...");  
	}

}
