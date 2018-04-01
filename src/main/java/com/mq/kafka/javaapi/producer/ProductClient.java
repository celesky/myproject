package com.mq.kafka.javaapi.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by pan on 2017/12/27.
 */
public class ProductClient {


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9091,127.0.0.1:9092");
        props.put("acks", "1");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 100000; i++){
            ProducerRecord producerRecord = new ProducerRecord<String, String>("my-replicated-topic2", Integer.toString(i), Integer.toString(i));

            //异步方式发送
//            producer.send(producerRecord,new Callback() {
//                @Override
//                public void onCompletion(RecordMetadata metadata, Exception e) {
//                    if(e != null){
//                        e.printStackTrace();
//                        //System.out.println("Error:The offset of the record we just sent is: " + metadata.offset()+"||||"+e.getCause());
//                    }else{
//                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
//                    }
//                }
//            });
            //同步方式发送
            Future<RecordMetadata> future =  producer.send(producerRecord);
            try {
                RecordMetadata rm =  future.get();
                System.out.println("we just sent is: topic:"+rm.topic()+" partition:"+rm.partition()+" offset:" + rm.offset());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }
}
