package com.yunus.controller;

import com.yunus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/10
 */
@RestController
@RequestMapping("/remote")
public class RemoteInvokeController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/users")
    public List<User> list() {
        List result = restTemplate.getForObject("http://clienta/api/users", List.class);
        return result;
    }
}
