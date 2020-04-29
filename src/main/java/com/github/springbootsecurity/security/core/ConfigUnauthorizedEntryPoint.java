package com.github.springbootsecurity.security.core;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 前后端分离时,使用该对象返回对方json 而不是 html
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

//@Component
public class ConfigUnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(@NotNull HttpServletRequest request,
                         @NotNull HttpServletResponse response,
                         @NotNull AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println("Unauthorized EntryPoint ");
        response.getWriter().flush();
    }

}
