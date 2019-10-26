package com.github.springbootsecurity.service.application;

import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 下午1:02 2019/10/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICaptchaService {

    void getCaptcha(HttpServletRequest request, HttpServletResponse response);

    String checkCode(String code, @NotNull HttpServletRequest request);
}
