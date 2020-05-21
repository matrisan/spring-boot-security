package com.github.springbootsecurity.security.exception.impl;


import com.github.springbootsecurity.security.exception.AbstractCodeInvalidException;

/**
 * <p>
 * 创建时间为 上午10:35 2020/5/21
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class SmsInvalidException extends AbstractCodeInvalidException {

    private static final long serialVersionUID = -1089925069449380678L;

    public SmsInvalidException(String msg) {
        super(msg);
    }

}
