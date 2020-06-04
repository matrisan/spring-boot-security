package com.github.springbootsecurity.security.pojo.dto;

import com.github.springbootsecurity.security.pojo.BaseEntity;
import lombok.Data;

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

@Data
public class SystemUserDTO extends BaseEntity {

    private static final long serialVersionUID = 8244210886033431393L;

    private String username;

}
