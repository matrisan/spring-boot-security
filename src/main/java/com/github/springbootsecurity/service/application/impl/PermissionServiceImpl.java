package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.service.application.IPermissionService;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午9:13 2019/12/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class PermissionServiceImpl implements IPermissionService {

    private static final Map<String, Set<String>> NAME_ROLE = Maps.newHashMap();

    static {
        NAME_ROLE.put("ROLE_ADMIN", Sets.newHashSet("message1"));
    }

    @Override
    public boolean hasPermission(@NotNull Authentication authentication) {
        Object principal = authentication.getPrincipal();
        Set<String> roleSet = ((UserDetails) principal).getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
//        return roleSet.stream().flatMap(one -> NAME_ROLE.get(one).stream()).collect(Collectors.toSet()).contains(path);
        return true;
    }

}
