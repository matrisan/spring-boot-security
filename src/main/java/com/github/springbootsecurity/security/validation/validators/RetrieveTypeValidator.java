package com.github.springbootsecurity.security.validation.validators;

import com.github.springbootsecurity.security.manager.AbstractForgetManager;
import com.github.springbootsecurity.security.validation.constraints.RetrieveType;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

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

public class RetrieveTypeValidator implements ConstraintValidator<RetrieveType, String> {

    @Resource
    private Map<String, AbstractForgetManager> iForgetManager;

    @Override
    public boolean isValid(String type, ConstraintValidatorContext context) {
        return iForgetManager.containsKey(type);
    }

}
