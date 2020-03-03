package com.github.springbootsecurity.security.pojo.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class CommonGroupVO implements Serializable {

    private static final long serialVersionUID = -239913222799855212L;

    private String groupName;

    private String groupNote;

    @JsonIgnoreProperties(value = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
    private SystemGroupDO parentGroup;

    @JsonIgnoreProperties(value = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
    private Set<SystemGroupDO> childGroup;

    @JsonIgnoreProperties(value = {"systemGroups", "systemUsers", "systemResources"})
    private Set<SystemRoleDO> systemRoles;

    @JsonIgnoreProperties(value = {"systemGroup", "systemRoles"})
    private Set<SystemUserDO> systemUsers;
}
