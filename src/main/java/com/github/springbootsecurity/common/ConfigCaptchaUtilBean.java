package com.github.springbootsecurity.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.Color;

/**
 * <p>
 * 创建时间为 下午1:29 2019/10/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Configuration
public class ConfigCaptchaUtilBean {

    @Bean
    public CaptchaUtil captchaUtil() {
        return CaptchaUtil.builder()
                .width(120).height(35).size(6).lines(8).fontSize(25).tilt(true).backgroundColor(Color.LIGHT_GRAY)
                .build();
    }

}
