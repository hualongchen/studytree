package com.lemon.chen.security;

import com.lemon.chen.service.CustoomBasicAuthEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * security的主要配置类--------->利用数据库进行权限数据的对比， userdetailsService
 */
@Configuration
@EnableWebSecurity

//prePostEnabled :确定 Spring Security 前置注释 [@PreAuthorize,@PostAuthorize,..] 是否应该启用；
//secureEnabled : 确定 Spring Security 安全注释 [@Secured] 是否应该启用；
//jsr250Enabled : 确定 JSR-250注释 [@RolesAllowed..] 是否应该启用；
@EnableGlobalMethodSecurity(prePostEnabled = true) //增加方法级别的控制
//  XML 写法如下 ：<global-method-security pre-post-annotations="enabled"/>
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("111").password("111").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("222").password("222").roles("USER");
    }


    /**
     * 设置权限
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").hasRole("ADMIN")
                .and().httpBasic().realmName("MY_TEST_REALM").authenticationEntryPoint(getBasicAuthEntryYiibai())
                //增加session的auth认证
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //增加只能一个人登陆，并记录在线人数。
        .maximumSessions(1).expiredUrl("/logout").sessionRegistry(sessionRegistry());
    }


    @Bean
    public CustoomBasicAuthEntry getBasicAuthEntryYiibai() {
        return new CustoomBasicAuthEntry();
    }

    /* To allow Pre-flight [OPTIONS] request from browser */
    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }


    /**
     * 跟踪活跃的session,统计在线人数,显示在线用户
     * @return
     */
    @Bean
    public SessionRegistry  sessionRegistry(){

        return new SessionRegistryImpl();
    }


}