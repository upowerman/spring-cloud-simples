package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lanxum
 */
@SpringBootApplication
@EnableConfigServer
public class DbConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbConfigServerApplication.class, args);

    }
}
