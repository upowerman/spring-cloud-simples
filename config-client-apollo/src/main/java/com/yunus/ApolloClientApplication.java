package com.yunus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


/**
 * 启动vm 配置 -Denv=dev -Denv_meta=http://localhost:8080
 *
 * @author lanxum
 */
@SpringBootApplication
public class ApolloClientApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(ApolloClientApplication.class, args);
    }
}
