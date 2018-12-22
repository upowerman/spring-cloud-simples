package com.yunus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/10
 */
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private String address;
}
