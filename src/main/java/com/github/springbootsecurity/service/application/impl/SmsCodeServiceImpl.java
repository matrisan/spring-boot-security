package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.SmsCode;
import com.github.springbootsecurity.service.application.ISmsCodeSenderService;
import com.github.springbootsecurity.service.application.ISmsCodeService;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;

import javax.annotation.Resource;
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

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Resource
    private ISmsCodeSenderService senderService;

    @Override
    public void sendSmsCode(String mobile, HttpServletRequest request, HttpServletResponse response) {
        // 1.生成随机码;
        // 2.发送短信
        // 3.存入Session;


    }

    @NotNull
    private SmsCode generater(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(6);
        return new SmsCode(code, 90);
    }


}
