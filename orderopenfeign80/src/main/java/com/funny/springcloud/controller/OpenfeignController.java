package com.funny.springcloud.controller;

import com.funny.springcloud.client.PaymentClient;
import com.funny.springcloud.entities.Payment;
import com.funny.springcloud.entities.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OpenfeignController {
    @Autowired
    private PaymentClient paymentClient;

    @PostMapping("/consumer/payment/save")
    public Result save(@RequestBody Payment payment){
        return paymentClient.save(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id){
        return paymentClient.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String testFeignTimeOut() {
        //feign默认服务调用是1秒超时
        return paymentClient.testFeignTimeOut();
    }
}
