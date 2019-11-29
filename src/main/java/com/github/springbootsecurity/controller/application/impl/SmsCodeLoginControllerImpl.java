package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.ISmsCodeLoginController;
import com.github.springbootsecurity.service.application.ISmsCodeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 上午11:05 2019/11/29
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class SmsCodeLoginControllerImpl implements ISmsCodeLoginController {

    @Resource
    private ISmsCodeService service;

    @PreAuthorize("permitAll()")
    @GetMapping("/code/sms/{mobile}")
    @Override
    public void getSmsCode(@PathVariable String mobile, HttpServletRequest request, HttpServletResponse response) {
        service.sendSmsCode(mobile, request, response);
    }

}
