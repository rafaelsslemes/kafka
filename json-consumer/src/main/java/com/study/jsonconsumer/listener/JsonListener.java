package com.study.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.study.jsonconsumer.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import static java.lang.Thread.sleep;

@Component
@Log4j2
public class JsonListener {
    
    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Payment received: {}", payment.toString());
        sleep(2000);
        
        log.info("Fraud Prevention...");
        sleep(2000);

        log.info("Purchase Approved");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment){
        log.info("Generating PDF File to payment ID={} ...", payment.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void emailSender(){
        log.info("Sending email...");
    }

}
