package com.yunus.service.impl;


import com.yunus.service.IHelloService;
import com.yunus.service.feign.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lanxum
 */
@Component
public class HelloService implements IHelloService {

    @Autowired
    private ProviderService dataService;

    @Override
    public List<String> getProviderData() {
        return dataService.getProviderData();
    }

}
