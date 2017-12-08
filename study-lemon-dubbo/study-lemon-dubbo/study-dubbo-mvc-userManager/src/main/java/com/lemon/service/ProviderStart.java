package com.lemon.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ProviderStart {


    //启动
    public static void main(String[] args) throws Exception{

        @SuppressWarnings("resource")
		ClassPathXmlApplicationContext  context =
                new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});

        context.start();

        //阻塞住---------
     System.in.read();
    }
}
