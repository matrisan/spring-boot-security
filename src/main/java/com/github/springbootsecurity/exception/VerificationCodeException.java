package com.github.springbootsecurity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 * 创建时间为 下午9:02 2019/10/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class VerificationCodeException extends AuthenticationException {

    private static final long serialVersionUID = -5415319408363885807L;

    public VerificationCodeException(String msg) {
        super(msg);
    }

    public VerificationCodeException(String msg, Throwable t) {
        super(msg, t);
    }


}
