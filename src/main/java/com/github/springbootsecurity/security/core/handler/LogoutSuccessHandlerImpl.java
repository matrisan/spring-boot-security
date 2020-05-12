package com.github.springbootsecurity.security.core.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 下午1:40 2020/5/12
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, @NotNull HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        int status = HttpServletResponse.SC_OK;
        log.info("用户退出登录成功处理器 - SystemLogoutSuccessHandler");
        String result = objectMapper.writeValueAsString(ResultVO.success("退出登录成功!"));
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(result);
        response.getWriter().flush();
    }
}
