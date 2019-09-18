package com.github.springbootsecurity.service;

import com.github.springbootsecurity.pojo.UserInfoDO;

/**
 * <p>
 * 创建时间为 下午1:12 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserRegisterService {

    /**
     * 注册新用户
     *
     * @param userInfoDO 用户信息
     * @return UserDomainDO
     */
    UserInfoDO register(UserInfoDO userInfoDO);

}
