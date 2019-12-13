package com.github.springbootsecurity.common;

import com.github.springbootsecurity.config.ConfigCaptchaProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
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

    @Resource
    private ConfigCaptchaProperty property;

    @Bean
    @ConditionalOnMissingBean
    public CaptchaUtil defaultCaptchaUtil() {
        return CaptchaUtil.builder()
                .width(120).height(35).size(6).lines(8).fontSize(25).tilt(true)
                .backgroundColor(Color.LIGHT_GRAY)
                .build();
    }

    @Bean
    @ConditionalOnMissingBean
    public CaptchaUtil captchaUtil() {
        return CaptchaUtil.builder()
                .width(120).height(35).size(6).lines(8).fontSize(25).tilt(true)
                .backgroundColor(Color.LIGHT_GRAY)
                .build();
    }

}
