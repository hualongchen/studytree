package com.lemon.chen.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class RestApiMethodController {



    @RequestMapping("/one")
    public String  one(){

        System.out.println("rest api 的鉴权验证");

        return  "success" ;
    }



}
