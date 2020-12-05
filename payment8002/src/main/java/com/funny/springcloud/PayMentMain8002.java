package com.funny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PayMentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8002.class,args);
    }
}
