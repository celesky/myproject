package com.netty.server;

import com.netty.client.handler.MessageDecoder;
import com.netty.server.BusiWorker.ServerWorkerThread;
import com.netty.server.handler.ChatMsgHandler;
import com.netty.server.handler.FirstServerHandler;
import com.netty.server.handler.HelloServerHandler;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    public static final ChannelGroup allChannels = new DefaultChannelGroup("time-server");

    public static void main(String args[]) {
        ChannelFactory factory = new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool());
        // Server服务启动器
        ServerBootstrap bootstrap = new ServerBootstrap(factory);
        // 设置一个处理客户端消息和各种消息事件的类(Handler)
        bootstrap.setPipelineFactory(()->Channels.pipeline(new MessageDecoder(),new FirstServerHandler(),new ChatMsgHandler()));

        // 开放8000端口供客户端访问。
        Channel channel = bootstrap.bind(new InetSocketAddress(8000));

        allChannels.add(channel);

        new ServerWorkerThread().start();
        //waitForShutdownCommand();
//        ChannelGroupFuture future = allChannels.close();
//        future.awaitUninterruptibly();
//        factory.releaseExternalResources();
    }

}
