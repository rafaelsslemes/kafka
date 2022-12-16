package com.study.paymentservice.service.impl;

import java.io.Serializable;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.study.paymentservice.model.Payment;
import com.study.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    @SneakyThrows // Dismiss throws declaration
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE ::: Payment received {}", payment);
        Thread.sleep(1000);
       
        log.info("Sending Payment");
         
        kafkaTemplate.send("payment-topic", payment);
    }
    
}
