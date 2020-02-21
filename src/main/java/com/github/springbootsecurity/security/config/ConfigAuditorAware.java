package com.github.springbootsecurity.security.config;

import com.github.springbootsecurity.security.pojo.SystemUserDO;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * <p>
 * 创建时间为 下午2:37 2020/2/20
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigAuditorAware implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (null == securityContext) {
            return Optional.empty();
        }
        Authentication authentication = securityContext.getAuthentication();
        if (null == authentication) {
            return Optional.empty();
        }
        SystemUserDO userDO = (SystemUserDO) authentication.getPrincipal();
        if (null == userDO) {
            return Optional.empty();
        }
        return Optional.ofNullable(userDO.getUserId());
    }


//    @Bean
//    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
//        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
//        methodInvokingFactoryBean.setTargetClass(SecurityContextHolder.class);
//        methodInvokingFactoryBean.setTargetMethod("setStrategyName");
//        methodInvokingFactoryBean.setArguments((Object) new String[]{SecurityContextHolder.MODE_INHERITABLETHREADLOCAL});
//        return methodInvokingFactoryBean;
//    }
}
