package com.github.springbootsecurity.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 上午12:44 2020/2/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class HelloMessageController {

    @GetMapping("/hello")
    public String message(){
        return "hello";
    }

}
