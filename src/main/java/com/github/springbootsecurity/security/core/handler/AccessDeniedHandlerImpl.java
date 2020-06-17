package com.github.springbootsecurity.security.core.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 下午4:41 2020/3/11
 * 项目名称 phoenix-user-pro-spring-boot-starter
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response,
                       @NotNull AccessDeniedException accessDeniedException) throws IOException {
        log.warn("AccessDeniedHandler");
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().println("SystemAccessDeniedHandler");
        response.getWriter().flush();
    }

}
