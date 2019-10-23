package com.github.springbootsecurity.service.security;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;

/**
 * <p>
 * 创建时间为 下午7:44 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserAuthorizeService {

    boolean hasPermission(@NotNull Authentication authentication, String bookName);
}
