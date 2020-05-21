package com.github.springbootsecurity.security.core;

import com.github.springbootsecurity.security.core.handler.InvalidSessionStrategyImpl;
import com.github.springbootsecurity.security.core.handler.SessionInformationExpiredStrategyImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

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
@RequiredArgsConstructor
public class WebSecurityConfigurerAdapterConfig extends WebSecurityConfigurerAdapter {

    private final LogoutSuccessHandler logoutSuccessHandler;

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationFailureHandler failureHandler;

    private final AuthenticationSuccessHandler successHandler;

    private final InvalidSessionStrategyImpl sessionInvalidStrategy;

    private final SessionInformationExpiredStrategyImpl sessionExpiredStrategy;

    private final AuthenticationEntryPoint unauthorizedEntryPoint;

    private final AccessDeniedHandler accessDeniedHandler;

    @Override
    @SneakyThrows(Exception.class)
    protected void configure(@NotNull AuthenticationManagerBuilder auth) {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    @SneakyThrows(Exception.class)
    protected void configure(@NotNull HttpSecurity http) {
        // 自定义的登录接口,使用表单登录
        // 自定义登录/登出url，自定义登录成功/失败处理器
        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and().logout().logoutUrl("/logout")
//                .logoutSuccessHandler()
        ;
        // 对 Session 的管理
        http.sessionManagement()
                // 登录超时处理
                .invalidSessionStrategy(sessionInvalidStrategy)
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                // 异地登录处理
                .expiredSessionStrategy(sessionExpiredStrategy);
        http.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
        http.csrf().disable();
//        http.apply(smsCodeAuthenticationSecurityConfig);
    }

    @Override
    @SneakyThrows(Exception.class)
    public void configure(@NotNull WebSecurity web) {
        web.ignoring().antMatchers("/");
        web.ignoring().antMatchers("/static/js/**");
        web.ignoring().antMatchers("/static/css/**");
        web.ignoring().antMatchers("/static/image/**");
    }

}
