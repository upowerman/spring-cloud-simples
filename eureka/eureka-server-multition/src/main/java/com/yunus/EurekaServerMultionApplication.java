package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/8
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMultionApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMultionApplication.class, args);
    }
}
