package com.jvm.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * 给selector注册一个管道socketChannel,和这个管道上的事件
 *
 */
public class NioServer {
    static int BLOCK = 1024;
    static String name = "";
    protected Selector selector;
    protected ByteBuffer clientBuffer = ByteBuffer.allocate(BLOCK);
    protected CharsetDecoder decoder;
    static CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();

    public NioServer(int port) throws IOException {
        selector = this.getSelector(port);
        Charset charset = Charset.forName("GB2312");
        decoder = charset.newDecoder();
    }

    // 获取Selector
    protected Selector getSelector(int port) throws IOException {
        Selector selctor = Selector.open();//打开一个selector
        ServerSocketChannel socketChannel = ServerSocketChannel.open();//打开管道
        socketChannel.socket().bind(new InetSocketAddress(port));
        socketChannel.configureBlocking(false);
        socketChannel.register(selctor, SelectionKey.OP_ACCEPT);//注册到selector
        return selctor;
    }

    // 监听端口
    public void listen() {
        try {
            for (;;) {
                selector.select();
                Iterator iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = (SelectionKey) iter.next();
                    iter.remove();
                    process(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 处理事件
    protected void process(SelectionKey key) throws IOException {
        if (key.isAcceptable()) { // 接收请求
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel channel = server.accept();
            //设置非阻塞模式
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) { // 读信息
            SocketChannel channel = (SocketChannel) key.channel();
            int count = channel.read(clientBuffer);
            if (count > 0) {
                clientBuffer.flip();
                CharBuffer charBuffer = decoder.decode(clientBuffer);
                name = charBuffer.toString();
                // System.out.println(name);
                SelectionKey sKey = channel.register(selector,
                        SelectionKey.OP_WRITE);
                sKey.attach(name);
            } else {
                channel.close();
            }

            clientBuffer.clear();
        } else if (key.isWritable()) { // 写事件
            SocketChannel channel = (SocketChannel) key.channel();
            String name = (String) key.attachment();

            ByteBuffer block = encoder.encode(CharBuffer
                    .wrap("Hello !" + name));


            channel.write(block);

            //channel.close();

        }
    }

    public static void main(String[] args) {
        int port = 8888;
        try {
            NioServer server = new NioServer(port);
            System.out.println("listening on " + port);

            server.listen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
