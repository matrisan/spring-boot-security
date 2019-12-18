package com.github.springbootsecurity.application.controller;

import com.github.springbootsecurity.application.pojo.DataDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午2:40 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@PreAuthorize("isAuthenticated()")
public class SayHiController {

    @GetMapping("hi")
    public String hi(@NotNull @AuthenticationPrincipal Authentication authentication) {
        return "hi  :  " + authentication.getName();
    }

    @PostMapping("hi")
    public DataDTO post(@RequestBody DataDTO data) {
        return data;
    }
}
