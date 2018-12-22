package com.yunus.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gaoyunfeng
 * @date: 2018/12/11
 */
@Configuration
//@RibbonClients(value = {
//        @RibbonClient(name = "client-a", configuration = RibbonRuleConfig.class),
//        @RibbonClient(name = "client-b", configuration = RibbonRuleConfig.class)
//})
@RibbonClient(name = "client-a", configuration = RibbonRuleConfig.class)
public class RibbonLbConfig {
}
