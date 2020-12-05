package com.funny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PayMentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8001.class,args);
    }
}
