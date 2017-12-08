package com.lemon.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lemon.api.UserManagerAPI;

public class Consumer {

	
	   public static void main(String[] args) {
		
		   @SuppressWarnings("resource")
			ClassPathXmlApplicationContext  context =
	                new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});

	        context.start();

	        
	      UserManagerAPI  api = (UserManagerAPI)context.getBean("userService");
	      
	      System.out.println("从zookeeper拿到对应的数据："+api.findUserById(3).toString());
	        
	}
}
