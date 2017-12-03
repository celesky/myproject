package com.netty.server.handler;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * Created by pan on 16/8/31.
 */
public class ChatMsgHandler extends SimpleChannelHandler {
    public void messageReceived(
            ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        //System.out.println("chatMsgHandler 还有酱油打吗" );

    }
}
