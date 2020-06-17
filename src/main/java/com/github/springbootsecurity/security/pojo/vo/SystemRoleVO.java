package com.github.springbootsecurity.security.pojo.vo;

import com.github.springbootsecurity.security.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

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

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SystemRoleVO extends BaseEntity {

    private static final long serialVersionUID = 3958468876052140234L;

    private String roleName;

    private String roleCode;

    private Set<SystemUserVO> users;

}
