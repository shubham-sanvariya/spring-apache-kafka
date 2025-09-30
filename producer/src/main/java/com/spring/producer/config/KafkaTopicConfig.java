package com.spring.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    
    @Bean
    NewTopic createMyTopic(){
        return new NewTopic("my-new-topic-config",3, (short) 1);
    }
}
