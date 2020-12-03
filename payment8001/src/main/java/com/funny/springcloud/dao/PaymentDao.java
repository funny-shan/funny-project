package com.funny.springcloud.dao;

import com.funny.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int save(Payment payment);
    Payment getPaymentById(Long id);
}
