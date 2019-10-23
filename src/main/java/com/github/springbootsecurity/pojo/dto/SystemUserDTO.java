package com.github.springbootsecurity.pojo.dto;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午7:54 2019/10/22
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserDTO implements Serializable {

    private static final long serialVersionUID = 7555526399927873421L;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String email;

    private Set<Long> roles;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    private String note;

}
