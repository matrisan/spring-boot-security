package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.ICaptchaController;
import com.github.springbootsecurity.service.application.ICaptchaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 下午1:01 2019/10/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class CaptchaControllerImpl implements ICaptchaController {

    @Resource
    private ICaptchaService service;

    @Override
    @GetMapping("/code/image")
    @PreAuthorize("permitAll()")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        service.getCaptcha(request, response);
    }

}
