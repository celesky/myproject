package com.netty.server.util;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pan on 16/8/31.
 */
public class ServerConnectionManager {
    private static AtomicLong ctxIdGen = new AtomicLong(1);
    private static ConcurrentHashMap<Long,ChannelHandlerContext> ctxMap = new ConcurrentHashMap<Long,ChannelHandlerContext>();

    public static void addCtx(ChannelHandlerContext ctx){
        Long no = ctxIdGen.getAndIncrement();
        ctxMap.put(no,ctx);
    }
    public static Map getCtxMap(){
        return ctxMap;
    }
    public static void main(String[] args) {
        //System.out.println("ctxId = " + ctxId);
    }
}
