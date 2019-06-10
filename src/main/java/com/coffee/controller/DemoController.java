package com.coffee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhang.hp
 * @date 2018/12/18.
 */
@Slf4j
@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("/hello")
    String  hello(){
        return "hello world";
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instances = client.getInstances("springboot-demo");
        for (int i = 0; i < instances.size(); i++) {
            log.info("/hello,host:" + instances.get(i).getHost() + ",service_id:" + instances.get(i).getServiceId());
        }
        return "discovery client";
    }


}
