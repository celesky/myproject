package com.netty.client.handler;

import com.netty.bean.ChatMessage;
import com.netty.client.BusiWorker.ClientRobotThread;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;

import java.util.Date;
import java.util.List;

/**
 * Created by pan on 16/8/24.
 */
public class HelloClientHandler extends SimpleChannelHandler {


    /**
     * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
     *
     * @alia OneCoder
     * @author lihzh
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx,
                                 ChannelStateEvent e) {
        //System.out.println("Hello world, I'm client.");
        //启动模拟客户端线程
        new ClientRobotThread().setCtx(ctx).start();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        System.out.println("发生异常了");
        e.getCause().printStackTrace();
        Channel ch = e.getChannel();
        ch.close();
    }

    /**
     * Invoked when a message object (e.g: {@link ChannelBuffer}) was received
     * from a remote peer.
     */
    @Override
    public void messageReceived(
            ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        //ctx.sendUpstream(e);
        System.out.println("[client][messageReceived-------------]"+e.getMessage());
        ChatMessage chatMessage = (ChatMessage)e.getMessage();
        System.out.println("chatMessage.getMsg() = " + chatMessage.getMsg());
//        ChannelBuffer buf = (ChannelBuffer) e.getMessage();
//        while (buf.readable()) {
//            System.out.print((char) buf.readByte());
//            System.out.flush();
//        }
        //ChannelBuffer buf = (ChannelBuffer) e.getMessage();
//        long currentTimeMillis = buf.readInt() * 1000L;
//        System.out.println(new Date(currentTimeMillis));
//        e.getChannel().close();


    }


}