package com.study.paymentservice.service.impl;

import org.springframework.stereotype.Service;

import com.study.paymentservice.model.Payment;
import com.study.paymentservice.service.PaymentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService{

    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE ::: Payment received {}", payment);
       
    }
    
}
