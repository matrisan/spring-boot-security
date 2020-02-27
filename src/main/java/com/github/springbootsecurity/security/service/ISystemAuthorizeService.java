package com.github.springbootsecurity.security.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;

/**
 * <p>
 * 创建时间为 下午4:09 2020/2/27
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemAuthorizeService {

    boolean hasSystemGroupPermission(String url, String method, @NotNull Authentication authentication);

    boolean hasSystemGroupPermission(String url, String method, @NotNull Authentication authentication, long groupId);

}
