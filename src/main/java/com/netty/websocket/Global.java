package com.netty.websocket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * Created by pan on 16/10/28.
 */
public class Global {
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

}
