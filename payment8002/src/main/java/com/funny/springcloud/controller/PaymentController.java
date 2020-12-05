package com.funny.springcloud.controller;

import com.funny.springcloud.entities.Payment;
import com.funny.springcloud.entities.Result;
import com.funny.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private DiscoveryClient discoveryClient;

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
        log.info("查询结束，结果:{}",paymentById);
        return new Result(200,"查询成功，serverPort："+serverPort,paymentById);
    }

    @GetMapping("/payment/discovery")
    public Result discovery(){
        log.info("开始获取服务注册中心注册的服务列表....");
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("服务名称serviceName:{}",service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            log.info("{}下有哪些实列：",service);
            for (ServiceInstance instance : instances) {
                log.info("uri:{}",instance.getUri());
                log.info("host:{}",instance.getHost());
                log.info("port:{}",instance.getPort());
                log.info("instanceId:{}",instance.getInstanceId());
                log.info("scheme:{}",instance.getScheme());
            }
        }
        return new Result(200,"获取服务列表成功！",services);
    }
}
