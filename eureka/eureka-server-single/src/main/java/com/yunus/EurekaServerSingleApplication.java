package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lanxum
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerSingleApplication.class, args);
    }
}
