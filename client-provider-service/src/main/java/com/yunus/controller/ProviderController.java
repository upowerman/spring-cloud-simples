package com.yunus.controller;

import com.yunus.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxum
 */
@RestController
public class ProviderController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/getDashboard")
    public List<String> getProviderData() {
        List<String> provider = new ArrayList<String>();
        provider.add("hystrix dashboard");
        return provider;
    }


    @GetMapping("/getHelloService")
    public String getHelloService() {
        return consumerService.getHelloServiceData();
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
        System.out.println("ProviderController, id is" + id);
        if (id == 1) {
            return new User("Toy", "123456", 10);
        } else if (id == 2) {
            return new User("Sky", "000000", 20);
        }
        return new User("San", "543210", 30);
    }
}
