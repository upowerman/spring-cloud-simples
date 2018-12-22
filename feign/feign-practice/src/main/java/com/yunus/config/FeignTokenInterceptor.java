package com.yunus.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/8
 */
@Component
public class FeignTokenInterceptor implements RequestInterceptor {

    private static final String HEADER_TOKEN_KEY = "Authorization";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (null == getHttpServletRequest()) {
            return;
        }
        // token 往后传
        requestTemplate.header(HEADER_TOKEN_KEY, getHeaders(getHttpServletRequest(), HEADER_TOKEN_KEY));
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    private String getHeaders(HttpServletRequest request, String header) {
        return request.getHeader(header);
    }
}
