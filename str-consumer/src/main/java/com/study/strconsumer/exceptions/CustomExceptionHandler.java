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
        log.warn("Proccessing ERROR detected!");
        return null;
    }
    
}
