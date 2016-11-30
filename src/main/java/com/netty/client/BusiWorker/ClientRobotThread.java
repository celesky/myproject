package com.netty.client.BusiWorker;

import com.netty.server.util.ServerConnectionManager;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;

import java.util.Map;

import static org.jboss.netty.buffer.ChannelBuffers.buffer;

/**
 * Created by pan on 16/8/31.
 */
public class ClientRobotThread extends Thread{
    private ChannelHandlerContext ctx = null;

    public void run(){
        while(true){
            if(ctx!=null){
                //发送一条应答过去告诉客户端
                String msg = "0000|0000|hello, every one:!this is the msg from client!";
                int len = msg.length();
                String lenl = "0";
                if(len<10){
                    lenl = "000"+len;
                }else if(len<100){
                    lenl = "00"+len;
                }else if(len<1000){
                    lenl = "0"+len;
                }
                msg = lenl+msg;

                ChannelBuffer buf = buffer(msg.getBytes().length);
                buf.writeBytes(msg.getBytes());
                ctx.getChannel().write(buf);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public ClientRobotThread setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        return this;
    }
}
