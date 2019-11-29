package com.github.springbootsecurity.controller.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 上午10:58 2019/11/29
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISmsCodeLoginController {

    void getSmsCode(String mobile, HttpServletRequest request, HttpServletResponse response);

}
