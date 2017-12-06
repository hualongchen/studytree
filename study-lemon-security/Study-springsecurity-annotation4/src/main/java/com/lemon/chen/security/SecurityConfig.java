package com.lemon.chen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
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
    @Qualifier("customUserDetailsService")
    private UserDetailsService  userDetailsService ;


    @Resource(name = "lemonDataSource")
    private DataSource  dataSource ;



    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
        //增加加密
        //auth.authenticationProvider(authenticationProvider());
    }


    /**
     * 采用BCRYPT进行加密验证。 保存数据库之前，调用这个进行加密。
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /**
     * 增加密码的校验者
     * @return
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



    /**
     * 设置权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().loginPage("/login")
                .usernameParameter("ssoId").passwordParameter("password")
                //新增记住我这个功能
                .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)
                //新增记住我这个功能
                .and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }


    /**
     * 增加记着我这个功能
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }

}