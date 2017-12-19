package com.lemon.chen.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * spring主文件。spring-context.xml
 */

@Configuration
@ComponentScan(basePackages = {"com.lemon.chen"},excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {
}
