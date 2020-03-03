package com.github.springbootsecurity.security.authorization;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 上午12:21 2020/2/28
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class AuthorizeRoleService {

    public boolean hasRolePermission(@NotNull Authentication authentication) {
        return true;
    }

    public boolean hasRolePermission(@NotNull Authentication authentication, long roleId) {
        return true;
    }
}
