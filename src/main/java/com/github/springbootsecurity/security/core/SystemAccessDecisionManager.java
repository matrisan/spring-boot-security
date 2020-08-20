//package com.github.springbootsecurity.security.core;
//
//import org.springframework.security.access.AccessDecisionManager;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//
//import java.util.Collection;
//
///**
// * @author 石少东
// * @date 2020-06-28 15:54
// * @since 1.0
// */
//
//
//public class SystemAccessDecisionManager implements AccessDecisionManager {
//
//    @Override
//    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//
//    }
//
//    @Override
//    public boolean supports(ConfigAttribute attribute) {
//        return false;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//}
