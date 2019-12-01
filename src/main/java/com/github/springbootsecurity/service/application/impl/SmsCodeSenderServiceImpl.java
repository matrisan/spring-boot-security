package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.service.application.ISmsCodeSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

@Slf4j
@Service
public class SmsCodeSenderServiceImpl implements ISmsCodeSenderService {

    @Override
    public void send(String mobile, String code) {
        log.info("向手机发动验证码:{}-{}", mobile, code);
    }
}
