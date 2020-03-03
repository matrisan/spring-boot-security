package com.github.springbootsecurity.security.authorization;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 下午10:25 2020/2/27
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class AuthorizeResourceService {

    public boolean hasResourcePermission(@NotNull Authentication authentication) {
        return true;
    }

    public boolean hasResourcePermission(@NotNull Authentication authentication, long groupId) {
        return true;
    }
}
