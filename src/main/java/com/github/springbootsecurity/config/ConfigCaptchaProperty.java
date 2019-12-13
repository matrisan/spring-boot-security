package com.github.springbootsecurity.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.awt.Color;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午3:50 2019/12/11
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "com.github.captcha")
public class ConfigCaptchaProperty {

    /**
     * 验证路径
     */
    private Set<String> checkPaths;

    /**
     * 过期时间,单位是秒
     */
    private Integer expireTime;

    /**
     * 默认字符数量
     */
    private Integer size;

    /**
     * 默认干扰线数量
     */
    private Integer lines;

    /**
     * 默认宽度
     */
    private Integer width;

    /**
     * 默认高度
     */
    private Integer height;

    /**
     * 默认字体大小
     */
    private Integer fontSize;

    /**
     * 默认字体倾斜
     */
    private Boolean tilt;

    /**
     * 背景颜色
     */
    private Color backgroundColor;
}

