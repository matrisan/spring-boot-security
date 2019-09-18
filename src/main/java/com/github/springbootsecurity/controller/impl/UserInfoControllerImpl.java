package com.github.springbootsecurity.controller.impl;

import com.alibaba.fastjson.JSON;
import com.github.springbootsecurity.controller.IUserInfoController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午12:45 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@RequestMapping("/user")
@PreAuthorize("isAuthenticated()")
@RestController
public class UserInfoControllerImpl implements IUserInfoController {

    @GetMapping("/auth")
    @Override
    public Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("getAuthentication:{}", JSON.toJSONString(authentication));
        return authentication;
    }

    @GetMapping("/info")
    @Override
    public UserDetails getUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("getUserDetails:{}", JSON.toJSONString(userDetails));
        return userDetails;
    }
}
