//package com.github.springbootsecurity.security.filter;
//
//import com.github.springbootsecurity.security.exception.AbstractCodeInvalidException;
//import com.github.springbootsecurity.security.pojo.bo.SmsCode;
//import com.google.common.collect.Sets;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.social.connect.web.HttpSessionSessionStrategy;
//import org.springframework.social.connect.web.SessionStrategy;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.bind.ServletRequestBindingException;
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.annotation.Resource;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Set;
//
//import static com.github.springbootsecurity.security.core.common.SecurityConstant.SESSION_KEY_CODE_SMS;
//import static com.github.springbootsecurity.security.core.common.SecurityConstant.SMS_CODE;
//
///**
// * <p>
// * 创建时间为 上午12:46 2019/10/24
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@Slf4j
//@Component
//public class SecuritySmsValidationFilter extends OncePerRequestFilter implements InitializingBean {
//
//    @Resource
//    private AuthenticationFailureHandler authenticationFailureHandler;
//
//    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//
//    private Set<String> urls = Sets.newHashSet();
//
//    private AntPathMatcher pathMatcher = new AntPathMatcher();
//
//    @Override
//    public void afterPropertiesSet() throws ServletException {
//        super.afterPropertiesSet();
//        String[] configs = StringUtils.splitByWholeSeparatorPreserveAllTokens("", ",");
//        urls.add("/authentication/mobile");
//    }
//
//    @Override
//    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
//        log.info("SecuritySmsValidationFilter");
//        if (StringUtils.equalsIgnoreCase("/authentication/mobile", request.getRequestURI()) &&
//                StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
//            try {
//                validate(new ServletWebRequest(request));
//            } catch (AbstractCodeInvalidException exception) {
//                authenticationFailureHandler.onAuthenticationFailure(request, response, exception);
//                return;
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private void validate(@NotNull ServletWebRequest servletWebRequest) throws AbstractCodeInvalidException, ServletRequestBindingException {
//        SmsCode smsCode = (SmsCode) sessionStrategy.getAttribute(servletWebRequest, SESSION_KEY_CODE_SMS);
//        String codeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), SMS_CODE);
//        if (StringUtils.isBlank(codeInRequest)) {
//            throw new AbstractCodeInvalidException("验证码不能为空字符串!");
//        }
//        if (smsCode == null) {
//            throw new AbstractCodeInvalidException("验证码不能为空!");
//        }
//        if (smsCode.expired()) {
//            sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_CODE_SMS);
//            throw new AbstractCodeInvalidException("验证码过期!");
//        }
//        if (!StringUtils.equalsIgnoreCase(codeInRequest.trim(), smsCode.getCode())) {
//            throw new AbstractCodeInvalidException("验证码不匹配!");
//        }
//        sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_CODE_SMS);
//    }
//}
