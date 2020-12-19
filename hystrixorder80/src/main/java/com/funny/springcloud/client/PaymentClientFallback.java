package com.funny.springcloud.client;

import org.springframework.stereotype.Component;

/**
 * @Author linshan
 * @Date 2020/12/19
 * @desc
 */
@Component
public class PaymentClientFallback implements PaymentClient{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentClientFallback---paymentInfo_OK---服务繁忙请稍后再试~~~~";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentClientFallback---paymentInfo_TimeOut---服务繁忙请稍后再试~~~~";
    }
}
