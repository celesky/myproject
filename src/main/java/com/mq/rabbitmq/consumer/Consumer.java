package com.mq.rabbitmq.consumer;

import com.mq.rabbitmq.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Consumer {

    private final static String QUEUE_NAME = "queue_simple";

    public static void main(String[] argv) throws Exception {
//
//        // 获取连接
//        Connection connection = ConnectionUtil.getConnection();
//        // 创建通道
//        Channel channel = connection.createChannel();
//
//        // 声明队列
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//        // 监听队列
//        channel.basicConsume(QUEUE_NAME, true, consumer);  //true 自动确认消息, 下有详解
//
//        // 获取消息
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery(); //阻塞或轮询
//            String message = new String(delivery.getBody());
//            System.out.println("获取:" + message);
//        }
    }
}
