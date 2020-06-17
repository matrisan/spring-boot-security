package com.github.springbootsecurity.security.pojo.vo;

import com.github.springbootsecurity.security.pojo.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Value;

/**
 * <p>
 * 创建时间为 下午3:31 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Value
@EqualsAndHashCode(callSuper = true)
public class SystemUserVO extends BaseEntity {

    private static final long serialVersionUID = -5148860861267867812L;

    String username;

    String mobile;

    String email;



}
