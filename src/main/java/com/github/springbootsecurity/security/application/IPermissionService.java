package com.github.springbootsecurity.security.application;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;

/**
 * <p>
 * 创建时间为 下午9:50 2019/12/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IPermissionService {

    boolean hasPermission(@NotNull Authentication authentication, String path);

}
