package com.yunus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lanxum
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class NacosConsumerServer {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerServer.class, args);
    }

    @FeignClient(name = "nacos-provider")
    public interface EchoService {
        @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
        String echo(@PathVariable("str") String str);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EchoService echoService;

    @RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-provider/echo/" + str,
                String.class);
    }

    @RequestMapping(value = "/echo-feign/{str}", method = RequestMethod.GET)
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

}

