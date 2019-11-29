package com.yunus.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lanxum
 */
@FeignClient(name = "client-hello-service")
public interface ConsumerService {

    @RequestMapping(value = "/helloService", method = RequestMethod.GET)
    String getHelloServiceData();
}
