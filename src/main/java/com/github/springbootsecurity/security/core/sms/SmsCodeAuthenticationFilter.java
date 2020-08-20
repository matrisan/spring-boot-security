//package com.github.springbootsecurity.security.core.sms;
//
//import org.jetbrains.annotations.Contract;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * <p>
// * 创建时间为 下午7:14 2019/10/26
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "mobile";
//
//    private String mobileParameter = SPRING_SECURITY_FORM_MOBILE_KEY;
//
//    private boolean postOnly = true;
//
//    public SmsCodeAuthenticationFilter() {
//        super(new AntPathRequestMatcher("/authentication/mobile", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        if (postOnly && !"POST".equals(request.getMethod())) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        }
//        String mobile = obtainMobile(request);
//        if (mobile == null) {
//            mobile = "";
//        }
//        mobile = mobile.trim();
//        SmsAuthenticationToken authRequest = new SmsAuthenticationToken(mobile);
//        // Allow subclasses to set the "details" property
//        setDetails(request, authRequest);
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//
//    private String obtainMobile(@NotNull HttpServletRequest request) {
//        return request.getParameter(mobileParameter);
//    }
//
//    private void setDetails(HttpServletRequest request, @NotNull SmsAuthenticationToken authRequest) {
//        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
//    }
//
//    public void setPostOnly(boolean postOnly) {
//        this.postOnly = postOnly;
//    }
//
//    @Contract(pure = true)
//    public final String getUsernameParameter() {
//        return mobileParameter;
//    }
//
//
//}
