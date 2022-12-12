package com.study.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StrConsumerListener {

    // Listeners from same group compete to partitions of topic
    // A single Listener in a group listens all partitions of topic

    @KafkaListener(groupId = "string-group", topics = "str-topic", containerFactory = "strContainerFactory")
    public void listen(String message){
        log.info("PROCCESS :: Message received: {}", message);
    }

    @KafkaListener(groupId = "string-group", topics = "str-topic", containerFactory = "strContainerFactory")
    public void auditLogs(String message){
        log.info("LOG ::: Message received: {}", message);
    }

    @KafkaListener(groupId = "other-string-group", topics = "str-topic", containerFactory = "strContainerFactory")
    public void paymentProccess(String message){
        log.info("PAYMENT ::: Message received: {}", message);
    }
}
