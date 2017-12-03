package com.emqtt.blockapi;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URISyntaxException;

/**
 * Created by pan on 2017/9/5.
 * 消息发布端
 */
public class PublishClient {
    private static final Logger logger = LoggerFactory.getLogger(PublishClient.class);

    //private final static String CONNECTION_STRING = "tcp://192.168.30.243:1883";
    private final static String CONNECTION_STRING = "tcp://127.0.0.1:1883";

    private final static boolean CLEAN_START = false;
    private final static String CLIENT_ID = "MessageService";
    private final static short KEEP_ALIVE = 30;// 低耗网络，但是又需要及时获取数据，心跳30s

//    public static Topic[] topics = {
//            new Topic("mqtt/aaa", QoS.EXACTLY_ONCE), // 2  只有一次
//            new Topic("mqtt/bbb", QoS.AT_LEAST_ONCE),  // 1 至少一次
//            new Topic("mqtt/ccc", QoS.AT_MOST_ONCE) };  // 0 至多一次

    public final static long RECONNECTION_ATTEMPT_MAX = 6;
    public final static long RECONNECTION_DELAY = 2000;

    public final static int SEND_BUFFER_SIZE = 64;// 发送最大缓冲
    private MQTT mqtt = new MQTT();
    private BlockingConnection connection = null;

    private static PublishClient publishClient = new PublishClient();

    public static PublishClient getInstance(){
        return publishClient;
    }

    private PublishClient(){
        try {
            //==MQTT设置说明
            //设置服务端的ip
            mqtt.setHost(CONNECTION_STRING);
            //连接前清空会话信息 ,若设为false，MQTT服务器将持久化客户端会话的主体订阅和ACK位置，默认为true
            mqtt.setCleanSession(CLEAN_START);
            //设置心跳时间 ,定义客户端传来消息的最大时间间隔秒数，服务器可以据此判断与客户端的连接是否已经断开，从而避免TCP/IP超时的长时间等待
            mqtt.setKeepAlive(KEEP_ALIVE);
            //设置客户端id,用于设置客户端会话的ID。在setCleanSession(false);被调用时，MQTT服务器利用该ID获得相应的会话。
            //此ID应少于23个字符，默认根据本机地址、端口和时间自动生成
            mqtt.setClientId(CLIENT_ID);

            //==失败重连接设置说明
            //设置重新连接的次数 ,客户端已经连接到服务器，但因某种原因连接断开时的最大重试次数，超出该次数客户端将返回错误。-1意为无重试上限，默认为-1
            mqtt.setReconnectAttemptsMax(RECONNECTION_ATTEMPT_MAX);
            //设置重连的间隔时间  ,首次重连接间隔毫秒数，默认为10ms
            mqtt.setReconnectDelay(RECONNECTION_DELAY);
            //设置socket发送缓冲区大小，默认为65536（64k）
            mqtt.setSendBufferSize(SEND_BUFFER_SIZE);
            ////设置发送数据包头的流量类型或服务类型字段，默认为8，意为吞吐量最大化传输
            mqtt.setTrafficClass(8);

            //==带宽限制设置说明
            mqtt.setMaxReadRate(0);//设置连接的最大接收速率，单位为bytes/s。默认为0，即无限制
            mqtt.setMaxWriteRate(0);//设置连接的最大发送速率，单位为bytes/s。默认为0，即无限制
            mqtt.setUserName("pubServer");
            mqtt.setPassword("pubServer");

        } catch (URISyntaxException e) {
            logger.error("PublishClient URISyntaxException "+e.getMessage(),e);
        } catch (Exception e) {
            logger.error("PublishClient Exception "+e.getMessage(),e);
        }finally{
        }
    }

    public void connect(){
        try{
            if(connection==null){
                connection = mqtt.blockingConnection();
            }
            if(!connection.isConnected()){
                connection.connect();
            }
        }catch (Exception e){
            logger.error("PublishClient connect "+e.getMessage(),e);
        }
    }


    public boolean publish(String message,String topic){
        try{
            // 用于发布消息，目前手机段不需要向服务端发送消息
            //主题的内容
            //String message="{\"autoid\":system,\"msgId\":\"6b86375767fe4ad299c9bbb29dbd3718\",\"userId\":4513855,\"appType\":\"12\",\"title\":\"\",\"content\":\"Logging\",\"viewType\":\"Logging\",\"display\":1,\"transience\":0,\"isRead\":0,\"deleted\":0,\"data1\":{\"你好\":\"中国\",\"hello\":\"world\"},\"createTime\":1502871600000,\"extra1\":\"{\\\"你好\\\":\\\"中国\\\",\\\"hello\\\":\\\"world\\\"}\",\"subTitle\":\"\",\"tagsType\":0,\"jpushType\":0,\"jpushTimeToAlive\":1}";
            //A retained message is a normal MQTT message with the retained flag set to true. The broker will store the last retained message and the corresponding QoS for that topic
            // connection.publish(topic, "this is a retained message".getBytes(), QoS.AT_LEAST_ONCE, true);
            if(connection==null||!connection.isConnected()){
                connect();
            }
            if(!connection.isConnected()){
                connection = mqtt.blockingConnection();
                connection.connect();
            }
            connection.publish(topic, message.getBytes(), QoS.AT_LEAST_ONCE,false);
            logger.info("MQTTBlockingServer.publish Message "+"Topic Title :"+topic+" context :"+message);
            return true;
        }catch(Exception e){
            logger.error("PublishClient publish "+e.getMessage(),e);
        }
        return false;


    }

    public void disconnect(){
        //断开连接
        try {
            connection.disconnect();
        } catch (Exception e) {
            logger.error("PublishClient disconnect "+e.getMessage(),e);
        }
    }

    public static void main(String[] args) {
        PublishClient.getInstance().connect();
        PublishClient.getInstance().publish("你好","111");
        PublishClient.getInstance().disconnect();
    }
}
