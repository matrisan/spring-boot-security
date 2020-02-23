package com.github.springbootsecurity.security.config;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 上午9:18 2019/12/5
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final Map<String, String> urlRoleMap = new HashMap<>();

    {
        urlRoleMap.put("/open/**", "ROLE_ANONYMOUS");
        urlRoleMap.put("/message1", "ROLE_ADMIN");
        urlRoleMap.put("/message2", "ROLE_ROOT");
        urlRoleMap.put("/demo", "ROLE_ROOT");
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        Set<String> set = urlRoleMap.entrySet().stream()
                .filter(one -> antPathMatcher.match(one.getKey(), url))
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());
        String[] array = new String[set.size()];
        set.toArray(array);
        return SecurityConfig.createList(array);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
