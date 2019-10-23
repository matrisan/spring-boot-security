package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.IUserRegisterController;
import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.service.application.IUserRegisterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午1:11 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@RequestMapping("/public")
@PreAuthorize("permitAll()")
public class UserRegisterControllerImpl implements IUserRegisterController {

    @Resource
    private IUserRegisterService service;

    @Override
    @PostMapping("/register")
    public SystemUserDO register(SystemUserDO systemUserDO) {
        return service.register(systemUserDO);
    }

}
