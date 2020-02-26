package com.github.springbootsecurity.security.core;

import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午9:40 2020/2/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class SystemAccessDecisionManager implements AccessDecisionManager {

    private static final String ROLE_ROOT = "ROLE_ROOT";

    @Override
    public void decide(@NotNull Authentication authentication, Object object, @NotNull Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        Set<String> userRoles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        if (userRoles.contains(ROLE_ROOT)) {
            return;
        }
        Set<String> needRoles = configAttributes.stream().map(ConfigAttribute::getAttribute).collect(Collectors.toSet());
        Collection<String> intersection = CollectionUtils.intersection(userRoles, needRoles);
        if (CollectionUtils.isEmpty(intersection)) {
            //匹配到有对应角色,则允许通过
            throw new AccessDeniedException("not allow");
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
