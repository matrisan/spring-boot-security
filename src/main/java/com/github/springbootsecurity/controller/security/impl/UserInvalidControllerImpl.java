package com.github.springbootsecurity.controller.security.impl;

import com.github.springbootsecurity.controller.security.IUserInvalidController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 上午11:01 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@RestController
public class UserInvalidControllerImpl implements IUserInvalidController {

    @GetMapping("/session/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @Override
    public String invalid() {
        return "session 失效";
    }

}
