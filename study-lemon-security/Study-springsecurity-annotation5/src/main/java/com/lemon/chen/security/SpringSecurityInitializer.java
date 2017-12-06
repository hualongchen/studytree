package com.lemon.chen.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


/**
 * 注册springSecurityFilter
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {



    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }
}