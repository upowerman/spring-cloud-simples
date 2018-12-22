package com.yunus.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * spring cloud中国社区
 * @author lanxum
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class HystrixCollapsingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCollapsingApplication.class, args);
    }
   
}
