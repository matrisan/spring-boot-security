package com.github.springbootsecurity.config;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 下午11:33 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
public class ConfigUserAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    @SneakyThrows(IOException.class)
    public void onAuthenticationSuccess(@NotNull HttpServletRequest httpServletRequest,
                                        @NotNull HttpServletResponse httpServletResponse,
                                        Authentication authentication) {
        System.out.println("-------------------- 登录成功 --------------------");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(authentication));
        String targetUrl = httpServletRequest.getRequestURI();
        new DefaultRedirectStrategy().sendRedirect(httpServletRequest, httpServletResponse, targetUrl);

    }
}
