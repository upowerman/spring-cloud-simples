package com.yunus.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/12
 */
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
    private int age;
}
