package com.lemon.chen.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource(value="classpath:config.properties")
@Data
public class LoadPropertiesConfig {
	
	
	@Value("${com.lemon.chen}")
	private String  configOne ;
	
	@Value("${com.lemon.chen2}")
	private String configTwo ;
	
	


}
