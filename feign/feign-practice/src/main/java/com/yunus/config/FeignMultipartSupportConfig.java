//package com.yunus.config;
//
//import feign.codec.Encoder;
//import feign.form.spring.SpringFormEncoder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Scope;
//
///**
// * @Author: gaoyunfeng
// * @date: 2018/12/8
// */
//@Configuration
//public class FeignMultipartSupportConfig {
//    @Bean
//    @Primary
//    @Scope("prototype")
//    public Encoder multipartFormEncoder() {
//        return new SpringFormEncoder();
//    }
//}
