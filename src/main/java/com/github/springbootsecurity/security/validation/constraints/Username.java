package com.github.springbootsecurity.security.validation.constraints;

import com.github.springbootsecurity.security.validation.validators.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 创建时间为 下午6:09 2020/3/5
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {

    String value() default "";

    String message() default "用户不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
