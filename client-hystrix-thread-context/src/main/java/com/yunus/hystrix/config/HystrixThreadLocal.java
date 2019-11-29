package com.yunus.hystrix.config;

/**
 * @author lanxum
 */
public class HystrixThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
}