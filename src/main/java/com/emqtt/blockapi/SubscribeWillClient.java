package com.emqtt.blockapi;

import org.fusesource.mqtt.client.*;

import java.net.URISyntaxException;

/**
 * Created by pan on 2017/7/5.
 */
public class SubscribeWillClient {

    private final static String CONNECTION_STRING = "tcp://127.0.0.1:1883";
    //private final static String CONNECTION_STRING = "ws://127.0.0.1:8083";

    private final static boolean CLEAN_START = false;//是否清除会话 或者说 是否保存离线消息
    private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s
    private final static String CLIENT_ID = "will_client";
    public static Topic[] topics = {
            new Topic("conection/lost", QoS.EXACTLY_ONCE) };  // 0 至多一次

    public static String[] unsubscribetopics = {
            new String("mqtt/aaa"), //  2 只有一次
            new String("mqtt/bbb"),  // 1 至少一次
            new String("mqtt/ccc") };  // 0 至多一次

    public final static long RECONNECTION_ATTEMPT_MAX = 6;
    public final static long RECONNECTION_DELAY = 2000;

    public final static int SEND_BUFFER_SIZE = 64 ;// 发送最大缓冲为2M

    public static void main(String[] args) {
        // 创建MQTT对象
        MQTT mqtt = new MQTT();
        try {
            // 设置mqtt broker的ip和端口
            mqtt.setHost(CONNECTION_STRING);
            // 连接前清空会话信息
            mqtt.setCleanSession(CLEAN_START);
            // 设置重新连接的次数
            mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
            // 设置重连的间隔时间
            mqtt.setReconnectDelay(RECONNECTION_DELAY);
            // 设置心跳时间
            mqtt.setKeepAlive(KEEP_ALIVE);
            // 设置缓冲的大小
            mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
            //设置客户端id
            mqtt.setClientId(CLIENT_ID);

            //遗嘱topic
            mqtt.setWillTopic("conection/lost");
            //遗嘱消息
            mqtt.setWillMessage("subWillClient lost connection!");
            mqtt.setWillQos(QoS.AT_LEAST_ONCE);// lastWillQos 设置为 1 或 2，以使消息持久保存在 WebSphere® MQ 中并且确保传递
            mqtt.setWillRetain(true);//要保留最后的断开连接信息，请将 lastWillRetained 设置为 true

            mqtt.setUserName("subWillClient");
            mqtt.setPassword("subWillClient");
            BlockingConnection connection = mqtt.blockingConnection();
            connection.connect();
            connection.subscribe(topics);
            connection.unsubscribe(unsubscribetopics);

            while (true) {
                Message message = connection.receive();
                message.ack();
                System.out.println("SubscribeWillClient.Receive  will Message " + "Topic Title :" + message.getTopic() + " context :"
                        + String.valueOf(message.getPayloadBuffer()));
                Thread.sleep(1000);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}