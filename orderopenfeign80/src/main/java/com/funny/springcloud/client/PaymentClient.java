package com.funny.springcloud.client;

import com.funny.springcloud.entities.Payment;
import com.funny.springcloud.entities.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentClient {
    @PostMapping("/payment/save")
    Result save(@RequestBody Payment payment);

    @GetMapping("/payment/get/{id}")
    Result getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String testFeignTimeOut();
}
