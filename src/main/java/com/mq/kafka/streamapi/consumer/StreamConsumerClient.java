package com.mq.kafka.streamapi.consumer;

import org.apache.kafka.common.serialization.Serdes;

import java.util.Arrays;

/**
 * Created by pan on 2017/12/28.
 */
public class StreamConsumerClient {

    public static void main(String[] args) {


//        Properties config = new Properties();
//        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
//        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka-broker1:9092");
//        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//        KStreamBuilder builder = new KStreamBuilder();
//        KStream<String, String> textLines = builder.stream("TextLinesTopic");
//        KTable<String, Long> wordCounts = textLines
//                .flatMapValues(textLine -> Arrays.asList(textLine.toLowerCase().split("\\W+")))
//                .groupBy((key, word) -> word)
//                .count("Counts");
//        wordCounts.to(Serdes.String(), Serdes.Long(), "WordsWithCountsTopic");
//
//        KafkaStreams streams = new KafkaStreams(builder, config);
//        streams.start();
//
//        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
    
}
