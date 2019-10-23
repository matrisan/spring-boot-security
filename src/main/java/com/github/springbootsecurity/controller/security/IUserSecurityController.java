package com.github.springbootsecurity.controller.security;

import com.github.springbootsecurity.pojo.dto.ReturnDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 下午1:16 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserSecurityController {

    /**
     * 需要登录时候引导用户到此
     *
     * @param request  请求数据
     * @param response 返回数据
     * @return ReturnDTO
     */
    ReturnDTO<String> authRequire(HttpServletRequest request, HttpServletResponse response);
}
