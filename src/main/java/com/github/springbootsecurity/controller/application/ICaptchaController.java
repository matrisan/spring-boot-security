package com.github.springbootsecurity.controller.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 下午7:14 2019/10/23
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICaptchaController {

    void getCaptcha(HttpServletRequest request, HttpServletResponse response);


}
