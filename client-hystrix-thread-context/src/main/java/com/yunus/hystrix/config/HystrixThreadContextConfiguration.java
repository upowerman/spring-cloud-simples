package com.yunus.hystrix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanxum
 */
@Configuration
public class HystrixThreadContextConfiguration {
	@Bean
	public SpringCloudHystrixConcurrencyStrategy springCloudHystrixConcurrencyStrategy() {
		return new SpringCloudHystrixConcurrencyStrategy();
	}
}