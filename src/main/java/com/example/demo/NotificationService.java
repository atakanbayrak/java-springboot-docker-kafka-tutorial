package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @KafkaListener(topics = "example-topic", groupId = "group-id")
    public void consume(String message){
        //start to send email process
        logger.info(String.format("Message receiver \n %s", message));

    }

}
