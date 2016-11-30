package com.netty.client.handler;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

/**
 * Created by pan on 16/8/24.
 */
public class TimeDecoder extends FrameDecoder {

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
        System.out.println("      buffer.readableBytes()=" + buffer.readableBytes());
//        if (buffer.readableBytes() < 27) {
//            return null;
//        }
        return "nihao!nihao!";
    }
}
