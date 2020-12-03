package com.funny.springcloud.controller;

import com.funny.springcloud.entities.Payment;
import com.funny.springcloud.entities.Result;
import com.funny.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/save")
    public Result save(@RequestBody Payment payment){
        int save = paymentService.save(payment);
        log.info("保存数据结果：{}",save);
        if (save>0){
            return new Result(200,"插入成功！");
        }else{
            return new Result(500,"插入失败！");
        }
    }

    @GetMapping("/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id){
        log.info("开始查询数据，参数id:{}",id);
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结束，结果:",paymentById);
        return new Result(200,"success",paymentById);
    }
}
