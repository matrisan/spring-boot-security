package com.github.springbootsecurity.security.core.handler;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 前后端分离时,使用该对象返回对方json 而不是 html
 * AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
 *
 * <p>
 * 创建时间为 下午8:38 2019/11/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @SneakyThrows(IOException.class)
    @Override
    public void commence(HttpServletRequest request, @NotNull HttpServletResponse response, AuthenticationException authException) {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println("Unauthorized EntryPoint ");
        response.getWriter().flush();
    }

}
