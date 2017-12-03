package com.netty.client;

import com.netty.client.BusiWorker.ClientRobotThread;
import com.netty.client.handler.HelloClientHandler;
import com.netty.client.handler.MessageDecoder;
import com.netty.client.handler.TimeDecoder;
import com.netty.client.handler.TimeEncoder;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String args[]) {
        ChannelFactory factory =  new NioClientSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool());
        // Client服务启动器
        ClientBootstrap bootstrap = new ClientBootstrap(factory );
        // 设置一个处理服务端消息和各种消息事件的类(Handler)
//        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
//            @Override
//            public ChannelPipeline getPipeline() throws Exception {
//                return Channels.pipeline(new HelloClientHandler());
//            }
//        });
        bootstrap.setPipelineFactory(() -> Channels.pipeline(
                new MessageDecoder(),
                //new TimeEncoder(),
                new HelloClientHandler()
        ));

        // 连接到本地的8000端口的服务端
        ChannelFuture future = bootstrap.connect(new InetSocketAddress(
                "127.0.0.1", 8000));

//        future.awaitUninterruptibly();
//        if (!future.isSuccess()) {
//            future.getCause().printStackTrace();
//        }
//        future.getChannel().getCloseFuture().awaitUninterruptibly();
//        factory.releaseExternalResources();

        //启动模拟客户端线程  在handler里面启动
        //new ClientRobotThread().setCtx(ctx).start();

    }

}
