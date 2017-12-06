package com.lemon.chen.web;


import com.lemon.chen.service.SerurityMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodSerurityControoler {


    @Autowired
    private SerurityMethodService  serurityMethodService ;



    @RequestMapping("/one")
    public String  test1(){

        serurityMethodService.one();

        return "hello" ;
    }


    @RequestMapping("/five")
    public String  test2(){

        serurityMethodService.update();

        return "hello" ;
    }


    @RequestMapping("/four")
    public String  test3(){

        serurityMethodService.findNum();

        return "hello" ;
    }


    @RequestMapping("/three")
    public String  test4(){

        serurityMethodService.three();

        return "hello" ;
    }


    @RequestMapping("/two")
    public String  test5(){

        serurityMethodService.two();

        return "hello" ;
    }
}
