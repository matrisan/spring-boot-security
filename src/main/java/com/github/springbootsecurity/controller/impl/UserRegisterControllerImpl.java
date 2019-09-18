package com.github.springbootsecurity.controller.impl;

import com.github.springbootsecurity.controller.IUserRegisterController;
import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.service.IUserRegisterService;
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
public class UserRegisterControllerImpl implements IUserRegisterController {

    @Resource
    private IUserRegisterService service;

    @Override
    public UserInfoDO register(UserInfoDO userInfoDO) {
        return service.register(userInfoDO);
    }

}
