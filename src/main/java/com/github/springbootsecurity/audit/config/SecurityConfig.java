package com.github.springbootsecurity.audit.config;

import com.github.springbootsecurity.audit.interceptor.AuditLogInterceptor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 下午1:23 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Resource
    private AuditLogInterceptor interceptor;

    /**
     * 不配置的话就是针对所有的请求，都走这个拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(@NotNull InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }


}
