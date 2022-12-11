package com.study.strproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StringProducerService {
    
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message)
        .thenAccept(this::onSuccess)
        .exceptionally(this::onError);
    }

    private Void onError(Throwable error){
        log.error("Error sending message");
        return null;
    }

    private void onSuccess(SendResult<String, String> result){

        log.info("Message sent {}", result.getProducerRecord().value());
        log.info("Partition: {}, Offset: {}", 
            result.getRecordMetadata().partition(),
            result.getRecordMetadata().offset());
    }
}
