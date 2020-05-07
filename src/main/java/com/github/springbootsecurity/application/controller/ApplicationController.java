package com.github.springbootsecurity.application.controller;

import com.github.springbootsecurity.application.pojo.AppDataDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p>
 * 创建时间为 上午10:23 2020/4/29
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class ApplicationController {

    @PreAuthorize("permitAll()")
    @GetMapping("/data1")
    public String data1() {
        return "Data1 -" + new Date().toString();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/data2")
    public String data2() {
        return "Data2 - " + new Date().toString();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("data3")
    public AppDataDTO data3(@RequestBody AppDataDTO app) {
        return app;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("csrf")
    public CsrfToken loadToken(@NotNull HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (CsrfToken) session.getAttribute(this.sessionAttributeName);
    }


    private static final String DEFAULT_CSRF_TOKEN_ATTR_NAME = HttpSessionCsrfTokenRepository.class
            .getName().concat(".CSRF_TOKEN");
    private String sessionAttributeName = DEFAULT_CSRF_TOKEN_ATTR_NAME;
}
