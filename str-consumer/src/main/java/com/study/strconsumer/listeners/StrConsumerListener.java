package com.study.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "string-group", topics = "str-topic", containerFactory = "strContainerFactory")
    public void listen(String message){
        log.info("Message received: {}", message);
    }
}
