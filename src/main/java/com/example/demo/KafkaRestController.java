package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaRestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/produce")
    public String ProduceMessage() {
        kafkaTemplate.send("example-topic", "MERHABA");
        return "Message sent: " + "Merhaba";
    }
// new changes updated recently
}
