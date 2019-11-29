package com.yunus.hystrix.config;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lanxum
 */
public class CacheContextInterceptor implements HandlerInterceptor {

    private HystrixRequestContext context;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2) {
        context = HystrixRequestContext.initializeContext();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2, ModelAndView arg3) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3) {
        context.shutdown();
    }

}
