package com.github.springbootsecurity.security.constraint.validator;

import com.github.springbootsecurity.security.constraint.ResetPassword;
import com.github.springbootsecurity.security.pojo.dto.ResetPasswordDTO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author 石少东
 * @date 2020-06-16 17:41
 */

@RequiredArgsConstructor
public class ResetPasswordValidator implements ConstraintValidator<ResetPassword, ResetPasswordDTO> {

    @Override
    public boolean isValid(@NotNull ResetPasswordDTO value, ConstraintValidatorContext context) {
        return StringUtils.equals(value.getPasswordNew1(),value.getPasswordNew2());
    }

}
