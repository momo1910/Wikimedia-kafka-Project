package com.kafka.Wikimedia.producer.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopics {
    @Value("${spring.kafka.topic.name}")
    public String wikiMediaKafkaTopic;
}
