package com.mq.rabbitmq.producer;

import com.mq.rabbitmq.Constants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SimpleProducer {


    public static void main(String[] argv) throws Exception {
        // 获取连接
        Connection connection = getConnection();
        // 创建通道
        Channel channel = connection.createChannel();

        // 声明队列 (不存在则创建)
        channel.queueDeclare(Constants.QUEUE_NAME, false, false, false, null);

        // 发送消息
        String message = "Hello World";
        channel.basicPublish("", Constants.QUEUE_NAME, null, message.getBytes());

        // 关闭通道和连接
        channel.close();
        connection.close();
    }


    public static Connection getConnection() throws Exception {
        //connection工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST);
        factory.setPort(Constants.PORT);
//        factory.setUsername("zx");
//        factory.setPassword("zx");
//        factory.setVirtualHost("/zx");
        // 通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
