package com.lemon.chen.Studyspringcloudserverprovider.web;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :chenhualong
 * @Date : created in 17:59 2018/1/2
 * @Description :
 */

@RestController
public class ServerController {



    @Resource
    private DiscoveryClient  discoveryClient ;


    @GetMapping("/hello")
    public String  hello(){

        System.out.println("service has:" + discoveryClient.getServices());
        return "hello spring cloud";
    }


    @PostMapping("/world")
    public String world(){

        return " hello spring cloud world" ;
    }


}
