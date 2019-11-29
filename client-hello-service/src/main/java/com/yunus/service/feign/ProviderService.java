package com.yunus.service.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * feign调用数据服务
 * @author lanxum
 */
@FeignClient(name = "client-provider-service")
public interface ProviderService {

    @RequestMapping(value = "/getDashboard", method = RequestMethod.GET)
    List<String> getProviderData();

}
