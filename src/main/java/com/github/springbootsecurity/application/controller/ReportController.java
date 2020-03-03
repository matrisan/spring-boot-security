package com.github.springbootsecurity.application.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 上午1:39 2020/3/2
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@PreAuthorize("isAuthenticated()")
@RestController
public class ReportController {

    @GetMapping("report")
    public String report() {
        return "report";
    }

}
