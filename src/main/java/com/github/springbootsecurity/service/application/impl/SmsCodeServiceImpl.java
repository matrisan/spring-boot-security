package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.service.application.ISmsCodeService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 创建时间为 上午11:09 2019/11/29
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SmsCodeServiceImpl implements ISmsCodeService {


    @Override
    public void sendSmsCode(String mobile, HttpServletRequest request, HttpServletResponse response) {
        // 1.生成随机码;
        // 2.发送短信
        // 3.存入Session;


    }

}
