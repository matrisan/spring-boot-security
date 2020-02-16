package com.github.springbootsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午3:03 2020/2/14
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@RequestMapping("user")
@PreAuthorize("isAuthenticated()")
public class ResourceController {

    @GetMapping("res")
    public String resource(){
        return "resource";
    }

}
