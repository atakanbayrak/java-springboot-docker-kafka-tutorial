package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaRestController(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/produce/{message}")
    public String ProduceMessage(@PathVariable String message){
        kafkaTemplate.send("example-topic", message);
        return "Message sent: " + message;
    }
// new changes updated
    @KafkaListener(topics = "example-topic")
    public void ConsumeMessage(String message){
        System.out.println("Received Message :" + message);
    }
}
