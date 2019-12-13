package com.github.springbootsecurity.filter;

import com.github.springbootsecurity.common.CaptchaUtil;
import com.github.springbootsecurity.config.ConfigSecurityConstant;
import com.github.springbootsecurity.exception.CaptchaNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>
 * 创建时间为 上午12:46 2019/10/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Component
public class SecurityCaptchaValidationFilter extends OncePerRequestFilter {

    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        log.info("SecurityCaptchaValidationFilter");
        if (StringUtils.equalsIgnoreCase("/authentication/form", request.getRequestURI()) &&
                StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
            try {
                validate(new ServletWebRequest(request));
            } catch (CaptchaNotValidException exception) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void validate(@NotNull ServletWebRequest servletWebRequest) {
        String requestCaptcha = servletWebRequest.getParameter("imageCode");
        HttpSession session = servletWebRequest.getRequest().getSession();
        CaptchaUtil.Captcha sessionCaptcha = (CaptchaUtil.Captcha) session.getAttribute(ConfigSecurityConstant.SESSION_CAPTCHA_CODE);
        if (null == sessionCaptcha) {
            throw new CaptchaNotValidException("验证码失效!重新获取");
        }
        if (sessionCaptcha.isExpired()) {
            session.removeAttribute(ConfigSecurityConstant.SESSION_CAPTCHA_CODE);
            throw new CaptchaNotValidException("验证码过期!");
        }
        int maxRetry = sessionCaptcha.getMaxRetry();
        if (maxRetry < 1) {
            session.removeAttribute(ConfigSecurityConstant.SESSION_CAPTCHA_CODE);
            throw new CaptchaNotValidException("验证码超过尝试次数!");
        }
        sessionCaptcha.setMaxRetry(--maxRetry);
        session.setAttribute(ConfigSecurityConstant.SESSION_CAPTCHA_CODE, sessionCaptcha);
        String captcha = sessionCaptcha.getCaptcha();
        if (!StringUtils.equalsIgnoreCase(captcha, requestCaptcha)) {
            throw new CaptchaNotValidException("验证码错误!");
        }
        // 验证成功以后清除 session 中的验证码
        session.removeAttribute(ConfigSecurityConstant.SESSION_CAPTCHA_CODE);
    }
}
