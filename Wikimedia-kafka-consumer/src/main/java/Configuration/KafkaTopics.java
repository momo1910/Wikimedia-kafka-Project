package Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopics {
    @Value("${spring.kafka.topic.name}")
    public String wikiMediaKafkaTopic;

    @Value("${spring.kafka.consumer.group-id}")
    public String groupId;

}
