package com.github.springbootsecurity.security.constraint;

import com.github.springbootsecurity.security.constraint.validator.UniqueMobileValidator;
import com.github.springbootsecurity.security.constraint.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 石少东
 * @date 2020-06-16 17:40
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = UniqueMobileValidator.class)
public @interface UniqueMobile {

    String value() default "";

    String message() default "手机号码存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
