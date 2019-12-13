package com.github.springbootsecurity.controller.application.impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午3:18 2019/12/11
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
public class IndexControllerImpl {

    @GetMapping("/success")
    public String index(){
        return "index!";
    }

}
