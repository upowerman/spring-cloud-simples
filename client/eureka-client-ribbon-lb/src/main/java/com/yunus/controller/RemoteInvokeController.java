package com.yunus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lanxum
 */
@RestController
@RequestMapping("/remote")
public class RemoteInvokeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient lbClient;

    @GetMapping("/users")
    public List listUsers() {
        List result = restTemplate.getForObject("http://client-a/api/users", List.class);
        System.out.println(result);
        return result;
    }

    @GetMapping("/users1")
    public void getPort() {
        ServiceInstance instance = this.lbClient.choose("client-a");
        System.out.println(instance.getHost() + ":" + instance.getPort());
    }

    @GetMapping("/users2")
    public void getPort2() {
        ServiceInstance instance = this.lbClient.choose("client-b");
        System.out.println(instance.getHost() + ":" + instance.getPort());
    }
}