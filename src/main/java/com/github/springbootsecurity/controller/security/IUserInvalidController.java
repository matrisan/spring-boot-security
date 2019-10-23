package com.github.springbootsecurity.controller.security;

/**
 * <p>
 * 创建时间为 下午12:37 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserInvalidController {

    /**
     * session 失效返回的信息
     *
     * @return String
     */
    String invalid();

}
