package com.funny.springcloud.service;

import com.funny.springcloud.entities.Payment;

public interface PaymentService {
    int save(Payment payment);
    Payment getPaymentById(Long id);
}
