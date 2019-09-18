package com.github.springbootsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 创建时间为 下午12:44 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserInfoController {

    /**
     * 只要登录用户才能访问
     * 获取本人的 Authentication
     *
     * @return Authentication
     */
    Authentication getAuthentication();

    /**
     * 只要登录用户才能访问
     * 获取本人的 UserDetails
     *
     * @param userDetails UserDetails
     * @return UserDetails
     */
    UserDetails getUserDetails(UserDetails userDetails);

}
