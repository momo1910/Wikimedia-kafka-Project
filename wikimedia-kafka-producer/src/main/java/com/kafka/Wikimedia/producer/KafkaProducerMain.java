package com.kafka.Wikimedia.producer;

import com.kafka.Wikimedia.producer.Producers.WikiMediaKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaProducerMain implements CommandLineRunner {
    public static void main(String[] args)  {
        SpringApplication.run(KafkaProducerMain.class);
    }
   @Autowired
    WikiMediaKafkaProducer wikiMediaKafkaProducer;
   @Override public void run(String... args) throws Exception {
       wikiMediaKafkaProducer.sendMessage();

    }
}
