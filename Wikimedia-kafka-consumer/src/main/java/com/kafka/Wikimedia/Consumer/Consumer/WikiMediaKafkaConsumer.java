package com.kafka.Wikimedia.Consumer.Consumer;

import com.kafka.Wikimedia.Consumer.Model.WikimediaDBRecord;
import com.kafka.Wikimedia.Consumer.Repository.WikiMediaRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaKafkaConsumer {

    @Autowired
    WikiMediaRepostory wikiMediaRepostory;

    @KafkaListener(topics = "${spring.kafka.topic.name}" ,groupId ="${spring.kafka.consumer.group-id}" )
    public void consume(String eventMessage){
        System.out.println("Message Recieved is " + eventMessage.toString());
        WikimediaDBRecord wikimediaDBRecord=new WikimediaDBRecord();
        wikimediaDBRecord.setData(eventMessage);
        wikiMediaRepostory.save(wikimediaDBRecord);
    }


}
