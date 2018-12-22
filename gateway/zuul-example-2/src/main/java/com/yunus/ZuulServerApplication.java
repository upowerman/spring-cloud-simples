package com.yunus;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;
import com.netflix.zuul.monitoring.MonitoringHelper;
import com.yunus.filter.PostFilter;
import com.yunus.filter.SecondPreFilter;
import com.yunus.filter.ThirdPreFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lanxum
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    /**
     * Groovy加载方法配置，20秒自动刷新
     */
    @Component
    public static class GroovyRunner implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            MonitoringHelper.initMocks();
            FilterLoader.getInstance().setCompiler(new GroovyCompiler());
            try {
                FilterFileManager.setFilenameFilter(new GroovyFileFilter());
                FilterFileManager.init(20, "E:\\iworkplace\\java-frame\\spring-cloud-leaning\\gateway\\zuul-example-2\\src\\main\\java\\com\\yunus\\groovy");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

//    @Bean
//    public FirstPreFilter firstPreFilter(){
//    	return new FirstPreFilter();
//    }

    @Bean
    public SecondPreFilter secondPreFilter() {
        return new SecondPreFilter();
    }

    @Bean
    public ThirdPreFilter thirdPreFilter() {
        return new ThirdPreFilter();
    }

//    @Bean
//    public ErrorFilter errorFilter(){
//    	return new ErrorFilter();
//    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
}

