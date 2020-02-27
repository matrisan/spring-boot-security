package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.service.ISystemAuthorizeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 下午4:10 2020/2/27
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SystemAuthorizeServiceImpl implements ISystemAuthorizeService {

    @Override
    public boolean hasSystemGroupPermission(String url, String method, @NotNull Authentication authentication) {
        return true;
    }

    @Override
    public boolean hasSystemGroupPermission(String url, String method,@NotNull Authentication authentication, long groupId) {
        return true;
    }
}
