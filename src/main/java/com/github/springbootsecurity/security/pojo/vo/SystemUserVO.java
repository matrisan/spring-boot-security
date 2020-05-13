package com.github.springbootsecurity.security.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.springbootsecurity.security.pojo.BaseEntity;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

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
public class SystemUserVO extends BaseEntity {

    private static final long serialVersionUID = -5148860861267867812L;

    private String username;

    private String mobile;

    private String email;

    private Date accountNonExpired;

    private Date accountNonLocked;

    private Date credentialsNonExpired;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginDate;

    private Set<SystemRoleVO> roles;

    @NotNull
    public static SystemUserVO mapper(SystemUserDO userDo) {
        SystemUserVO vo = new SystemUserVO();
        BeanUtils.copyProperties(userDo, vo, "roles");
        vo.setRoles(mapper(userDo.getRoles()));
        return vo;
    }

    private static Set<SystemRoleVO> mapper(@NotNull Set<SystemRoleDO> roles) {
        return roles.stream().map(one -> {
            SystemRoleVO vo = new SystemRoleVO();
            BeanUtils.copyProperties(one, vo, "users");
            return vo;
        }).collect(Collectors.toSet());
    }

}
