package com.github.springbootsecurity.security.service;

/**
 * <p>
 * 创建时间为 下午6:59 2019/12/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISmsCodeSenderService {

    void send(String mobile, String code);

}
