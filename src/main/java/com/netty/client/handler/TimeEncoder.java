package com.netty.client.handler;

import com.netty.bean.UnixTime;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import static org.jboss.netty.buffer.ChannelBuffers.buffer;

/**
 * Created by pan on 16/8/24.
 */
public class TimeEncoder extends SimpleChannelHandler {
    public void writeRequested(ChannelHandlerContext ctx, MessageEvent e) {
        //UnixTime time = (UnixTime) e.getMessage();


//
//        Channels.write(ctx, e.getFuture(), buf);

    }
}
