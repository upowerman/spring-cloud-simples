package com.yunus.controller;

import com.yunus.feign.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/8
 */
@RestController
@RequestMapping("/")
public class HelloFeignController {

    @Autowired
    private HelloFeignService helloFeignService;

    @GetMapping("/search/github")
    public String searchGithubRepoByStr(@RequestParam("str") String str) {
        return helloFeignService.searchRepo(str);
    }
}
