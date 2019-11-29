package com.yunus.sleuth.consumer;

import brave.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户交互接口,分别使用feign,restTemplate,新线程的方式请求服务端
 * @author lanxum
 */
@RestController
public class ConsumerController {
    private static final Logger log = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    private HelloService helloService;
    @Autowired
    private Tracer tracer;

    @GetMapping("/hello")
    public String hello(String name){
        System.out.println(tracer.currentSpan().context().traceId());
        System.out.println(tracer.currentSpan().context().spanId());
        return helloService.sayHello(name);
    }
}
