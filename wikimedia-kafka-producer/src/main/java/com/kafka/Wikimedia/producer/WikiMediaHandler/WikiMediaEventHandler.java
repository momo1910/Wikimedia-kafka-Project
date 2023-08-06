package com.kafka.Wikimedia.producer.WikiMediaHandler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class WikiMediaEventHandler implements EventHandler {

    KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    public String wikiMediaKafkaTopic;

    public WikiMediaEventHandler(KafkaTemplate<String, String> kafkaTemplate, String wikiMediaKafkaTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.wikiMediaKafkaTopic = wikiMediaKafkaTopic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        kafkaTemplate.send(wikiMediaKafkaTopic,messageEvent.getData());
        System.out.println("Kafka Message send successfully"+ messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
