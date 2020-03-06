package com.github.springbootsecurity.security.validation.constraints;

import com.github.springbootsecurity.security.validation.validators.RetrieveTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * 创建时间为 下午6:05 2020/3/5
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
//指定注解的处理类
@Constraint(validatedBy = {RetrieveTypeValidator.class})
public @interface RetrieveType {

    String value() default "";

    String message() default "RetrieveType不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
