package com.github.springbootsecurity.security.core;

import com.github.springbootsecurity.security.pojo.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * <p>
 * 创建时间为 上午11:09 2020/2/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigAuditorAware implements AuditorAware<String> {

    @NotNull
    @Override
    public Optional<String> getCurrentAuditor() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (null == securityContext) {
            return Optional.of("System");
        }
        Authentication authentication = securityContext.getAuthentication();
        if (null == authentication) {
            return Optional.of("System");
        }
        SystemUserDO userDO = (SystemUserDO) authentication.getPrincipal();
        if (null == userDO) {
            return Optional.of("System");
        }
        return Optional.ofNullable(userDO.getUsername());
    }

}
