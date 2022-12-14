package com.study.paymentservice.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.study.paymentservice.model.Payment;
import com.study.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService{

    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE ::: Payment received {}", payment);
       
    }
    
}
