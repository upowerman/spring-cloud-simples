package com.yunus.sleuth.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lanxum
 */
@SpringBootApplication
@EnableFeignClients
public class SleuthConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SleuthConsumerApplication.class,args);
    }
}
