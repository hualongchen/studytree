package com.lemon.chen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * security的主要配置类
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("111").password("111").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("1").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("1").roles("DBA");
	}


	//.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/admin/**").access("hasRole('ROLE_USER')")
				.and()
				.formLogin().loginPage("/login").failureUrl("/login?error")
				.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("username").passwordParameter("password")
				.and()
				.logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/login?logout")
				.and()
				.csrf();

	}
}