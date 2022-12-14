package com.study.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomExceptionHandler implements KafkaListenerErrorHandler{

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.warn("::: ERROR ::: Proccessing ERROR detected!");
        log.info("::: PAYLOAD ::: " + message.getPayload().toString());
        log.info("::: HEADER ::: " + message.getHeaders().toString());
        log.info("::: OFFSET ::: " + message.getHeaders().get("kafka_offset"));
        return null;
    }
    
}
