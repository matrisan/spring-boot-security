package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.IApplicationIndexController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 创建时间为 下午9:10 2019/10/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Controller
public class ApplicationIndexControllerImpl implements IApplicationIndexController {

    @Override
    @GetMapping("/login")
    @PreAuthorize("permitAll()")
    public String login() {
        return "login";
    }


}
