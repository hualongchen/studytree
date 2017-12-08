package com.lemon.chen;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lemon.chen.util.LoadPropertiesConfig;

@Controller
public class UserController {

	
	@Resource
	private LoadPropertiesConfig  loadPropertiesConfig ;
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public Object  helloWord(){
		
		System.out.println("nice to you:"+loadPropertiesConfig.getConfigOne());
		
		return "hello word !";
	}
}
