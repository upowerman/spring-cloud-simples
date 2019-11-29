package com.yunus.hystrix.service;

import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;

/**
 * @author lanxum
 */
public interface IHelloService {
    String hello(Integer id);

    String getUserToCommandKey(@CacheKey Integer id);

    String updateUser(@CacheKey Integer id);
}
