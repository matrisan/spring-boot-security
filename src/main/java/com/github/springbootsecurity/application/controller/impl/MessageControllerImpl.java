package com.github.springbootsecurity.application.controller.impl;

import com.github.springbootsecurity.application.controller.IMessageController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

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
@PreAuthorize("isAuthenticated()")
public class MessageControllerImpl implements IMessageController {

    @CrossOrigin
//    @PreAuthorize("permitAll()")
    @GetMapping("/index")
    public String index() {
        return "index";
    }


    //    @PreAuthorize("@permissionServiceImpl.hasPermission(authentication,'getMessage1')")
    @GetMapping("/message1")
    @Override
    public String getMessage1() {
        return "getMessage1:" + new Date().toString();
    }

    @GetMapping("/message2")
    public String getMessage2() {
        return "getMessage2:" + new Date().toString();
    }

    @PostMapping("/message2")
    public Map<String, String> postMessage2(@RequestBody Map<String, String> map) {
        return map;
    }

    @RequestMapping("/csrf")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
