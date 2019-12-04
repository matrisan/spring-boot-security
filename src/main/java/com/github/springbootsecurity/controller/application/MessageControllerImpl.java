package com.github.springbootsecurity.controller.application;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 * 创建时间为 下午9:09 2019/12/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class MessageControllerImpl implements IMessageController {

    @PreAuthorize("@permissionServiceImpl.hasPermission(authentication,'getMessage1')")
    @GetMapping("/message1")
    @Override
    public String getMessage1() {
        return "getMessage1:" + new Date().toString();
    }

    @GetMapping("/message2")
    public String getMessage2() {
        return "getMessage2:" + new Date().toString();
    }


}
