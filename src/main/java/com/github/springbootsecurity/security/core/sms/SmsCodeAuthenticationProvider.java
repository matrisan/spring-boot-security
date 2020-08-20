//package com.github.springbootsecurity.security.core.sms;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.InternalAuthenticationServiceException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import javax.annotation.Resource;
//
///**
// * <p>
// * 创建时间为 下午7:20 2019/10/26
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
//@Getter
//@Setter
//public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
//
//    @Resource
//    private UserDetailsService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        SmsAuthenticationToken smsAuthenticationToken = (SmsAuthenticationToken) authentication;
//        UserDetails user = userDetailsService.loadUserByUsername((String) smsAuthenticationToken.getPrincipal());
//        if (user == null) {
//            throw new InternalAuthenticationServiceException("无法获取用户信息");
//        }
//        SmsAuthenticationToken authenticationResult = new SmsAuthenticationToken(user, user.getAuthorities());
//        authenticationResult.setDetails(smsAuthenticationToken.getDetails());
//        return authenticationResult;
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return SmsAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}
