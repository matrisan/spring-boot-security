package com.github.springbootsecurity.security.validation.validators;

import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.github.springbootsecurity.security.validation.constraints.Username;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>
 * 创建时间为 下午6:06 2020/3/5
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Resource
    private ISystemUserRepository repository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return repository.existsByUsernameEquals(username);
    }
}
