package com.github.springbootsecurity.controller;

import com.github.springbootsecurity.pojo.UserInfoDO;

/**
 * <p>
 * 创建时间为 下午1:01 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserRegisterController {

    /**
     * 注册用户
     *
     * @param userInfoDO UserInfoDO
     * @return UserInfoDO
     */
    UserInfoDO register(UserInfoDO userInfoDO);

}
