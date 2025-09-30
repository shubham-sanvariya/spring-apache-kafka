package com.spring.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.producer.dto.RiderLocation;

@RestController
@RequestMapping("/api")
public class KafkaProducer {
    
    private final KafkaTemplate<String,RiderLocation> kafkaTemplate;
    
    public KafkaProducer(KafkaTemplate<String, RiderLocation> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        RiderLocation riderLocation = new RiderLocation("rider123",28.61,38.87);
        kafkaTemplate.send("my-topic", riderLocation);
        return "Message sent: " + riderLocation.riderId();
    }
}
