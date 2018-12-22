package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/8
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientMultitionApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientMultitionApplication.class, args);
    }
}
