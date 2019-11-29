package com.yunus.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;


/**
 * @author lanxum
 */
@Configuration
@EnableApolloConfig(value = "application", order = 10)
public class AppConfig {
}
