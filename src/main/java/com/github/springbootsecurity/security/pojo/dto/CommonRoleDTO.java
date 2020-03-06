package com.github.springbootsecurity.security.pojo.dto;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午2:58 2020/3/1
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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CommonRoleDTO implements Serializable {

    private static final long serialVersionUID = -4430099506865934405L;

    private String roleName;

    private String roleNote;

    private Set<SystemGroupDO> systemGroups;

    private Set<SystemUserDO> systemUsers;

    private Set<SystemResourceDO> systemResources;

}
