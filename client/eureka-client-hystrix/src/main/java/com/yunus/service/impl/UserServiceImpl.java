package com.yunus.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yunus.entity.User;
import com.yunus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    @HystrixCommand(fallbackMethod = "defaultUser")
    public List<User> list() {
        List<User> list = new ArrayList<>();
        list.add(new User().setName("zhangsan").setId(1).setAddress("beijing"));
        return list;
    }

    public List<User> defaultUser() {
        return null;
    }
}

