package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author lanxum
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigGitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigGitApplication.class, args);

    }
}
