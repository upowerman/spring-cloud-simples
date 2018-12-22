package com.yunus.api;

import com.yunus.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/10
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/users")
    public List<User> listUser() {
        List<User> result = new ArrayList<>();
        User user = new User().setId(1).setName("zhangsan").setAddress("北京");
        result.add(user);
        return result;
    }
}
