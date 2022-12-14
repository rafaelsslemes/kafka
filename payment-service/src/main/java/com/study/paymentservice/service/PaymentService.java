package com.study.paymentservice.service;

import com.study.paymentservice.model.Payment;

public interface PaymentService {
    
    void sendPayment(Payment payment);
}
