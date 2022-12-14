package com.study.strconsumer.listeners;

import org.springframework.stereotype.Component;

import com.study.strconsumer.custom.StrCustomListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StrConsumerListener {

    // Listeners from same group compete to partitions of topic
    // A single Listener in a group listens all partitions of topic

    // @KafkaListener(groupId = "string-group",
    //     topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"0"})},
    //     containerFactory = "strContainerFactory")
    // public void listen(String message){
    //     log.info("PROCCESS :: Message received: {}", message);
    // }

    @StrCustomListener(groupId = "string-group")
    public void listen(String message){
        log.info("PROCCESS :: Message received: {}", message);
        throw new IllegalArgumentException("Invalid value");

}

    @StrCustomListener(groupId = "string-group")
    public void auditLogs(String message){
        log.info("LOG ::: Message received: {}", message);
    }

    @StrCustomListener(groupId = "other-string-group", containerFactory = "strInterceptedContainerFactory")
    public void paymentProccess(String message){
        log.info("PAYMENT ::: Message received: {}", message);
    }
}
