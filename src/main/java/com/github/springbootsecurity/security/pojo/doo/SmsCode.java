package com.github.springbootsecurity.security.pojo.doo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 创建时间为 下午6:55 2019/12/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmsCode implements Serializable {

    private static final long serialVersionUID = -2815701331592767971L;

    private String code;

    private LocalDateTime expireTime;

    public SmsCode(String code, int in) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(in);
    }

    public boolean expired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

}
