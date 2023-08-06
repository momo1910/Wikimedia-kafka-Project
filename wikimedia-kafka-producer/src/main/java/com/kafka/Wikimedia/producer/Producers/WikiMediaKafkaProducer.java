package com.kafka.Wikimedia.producer.Producers;

import com.kafka.Wikimedia.producer.WikiMediaHandler.WikiMediaEventHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiMediaKafkaProducer {

    @Value("${spring.kafka.topic.name}")
    public String wikiMediaKafkaTopic;

    KafkaTemplate<String,String> kafkaTemplate;

    public WikiMediaKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage() throws InterruptedException {
        EventHandler eventHandler=new WikiMediaEventHandler(kafkaTemplate,wikiMediaKafkaTopic);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource=builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(5);
    }
}
