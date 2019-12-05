package com.github.springbootsecurity.config;

import com.github.springbootsecurity.security.MyAccessDecisionManager;
import com.github.springbootsecurity.security.MyFilterInvocationSecurityMetadataSource;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午8:34 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class ConfigUserSecurity extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationFailureHandler failureHandler;

    @Resource
    private AuthenticationSuccessHandler successHandler;

    @Resource
    private BackLoginAuthenticationSecurityConfig backLoginAuthenticationSecurityConfig;

    @Override
    @SneakyThrows(Exception.class)
    protected void configure(@NotNull AuthenticationManagerBuilder auth) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    @SneakyThrows(Exception.class)
    protected void configure(@NotNull HttpSecurity http) {

        // 使用表单登录
        http.formLogin()
                // 指定登录页面
                .loginPage("/login").defaultSuccessUrl("/success").permitAll()
                // 自定义的登录接口
                .loginProcessingUrl("/authentication/form")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                // 定义哪些URL需要被保护、哪些不需要被保护
                .and().authorizeRequests()
                // 允许访问
                .antMatchers("/code/*", "/authentication/form", "/authentication/*", "/", "/session/invalid", "/register", "captcha")
                .permitAll()
                // 任何请求,登录后可以访问
                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setSecurityMetadataSource(mySecurityMetadataSource());
                        object.setAccessDecisionManager(myAccessDecisionManager());
                        return object;
                    }
                })
                .and()
                .logout().permitAll()
                .and()
                .sessionManagement()
                .invalidSessionUrl("/session/invalid")
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                .expiredSessionStrategy(event -> event.getResponse().getWriter().write("maxSessionsPreventsLogin !\n"))
                .and()
                .and().exceptionHandling().accessDeniedPage("/403")

        ;
        http.csrf().disable();
        http.apply(backLoginAuthenticationSecurityConfig);
    }

    @Bean
    public FilterInvocationSecurityMetadataSource mySecurityMetadataSource() {
        return new MyFilterInvocationSecurityMetadataSource();
    }

    @Bean
    public AccessDecisionManager myAccessDecisionManager() {
        return new MyAccessDecisionManager();
    }

    @Override
    @SneakyThrows(Exception.class)
    public void configure(@NotNull WebSecurity web) {
        web.ignoring().antMatchers("/static/js/**");
        web.ignoring().antMatchers("/static/css/**");
        web.ignoring().antMatchers("/static/image/**");
    }

}
