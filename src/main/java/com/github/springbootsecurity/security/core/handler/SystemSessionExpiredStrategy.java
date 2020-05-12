package com.github.springbootsecurity.security.core.handler;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 下午1:56 2020/5/11
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class SystemSessionExpiredStrategy  implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(@NotNull SessionInformationExpiredEvent event) throws IOException {
        log.info("用户在异地登录，请重新登录！");
        HttpServletResponse response = event.getResponse();
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print("用户在异地登录，请重新登录！");
        response.getWriter().flush();
    }
}
