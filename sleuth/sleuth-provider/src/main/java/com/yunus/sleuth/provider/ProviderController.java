package com.yunus.sleuth.provider;

import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sleuth-provider 对外服务接口
 *
 * @author lanxum
 */
@RestController
public class ProviderController {

    @Autowired
    private Tracer tracer;

    @GetMapping("/sayHello")
    public String hello(String name) {
        System.out.println(tracer.currentSpan().context().traceId());
        System.out.println(tracer.currentSpan().context().spanId());
        return "hello, " + name + ",SessionId is " + ExtraFieldPropagation.get("SessionId");
    }
}
