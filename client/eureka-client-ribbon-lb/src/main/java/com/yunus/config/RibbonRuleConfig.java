package com.yunus.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lanxum
 */
@Configuration
@AvoidScan
public class RibbonRuleConfig {
	
	@Autowired
    IClientConfig config;

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new RandomRule();
	}


}