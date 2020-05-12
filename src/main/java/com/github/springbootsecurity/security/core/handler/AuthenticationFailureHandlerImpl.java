package com.github.springbootsecurity.security.core.handler;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 下午11:34 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
//@Configuration
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    @SneakyThrows(IOException.class)
    public void onAuthenticationFailure(@NotNull HttpServletRequest httpServletRequest,
                                        @NotNull HttpServletResponse httpServletResponse,
                                        AuthenticationException e) {
        System.out.println("-------------------- 登录失败 --------------------");
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(e));
    }

}
