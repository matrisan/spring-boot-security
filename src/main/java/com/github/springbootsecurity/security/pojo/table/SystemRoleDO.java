package com.github.springbootsecurity.security.pojo.table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午8:35 2020/2/17
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
@ToString(exclude = {"systemGroups", "systemResources", "systemUsers"})
@EqualsAndHashCode(callSuper = false, exclude = {"systemGroups", "systemResources", "systemUsers"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "deleted = false")
@Table(name = "system_role", indexes = {@Index(columnList = "role_name", name = "IDX_ROLE_NAME")})
@DynamicInsert
@DynamicUpdate
public class SystemRoleDO extends BaseEntity implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 3274762729475775435L;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '角色名称'")
    private String roleName;

    @Column(name = "note", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '角色备注'")
    private String note;

    @ManyToMany(mappedBy = "systemRoles")
    @JsonIgnoreProperties(value = {"systemRoles", "systemUsers", "parentGroup", "childGroup"})
    private Set<SystemGroupDO> systemGroups;

    @ManyToMany(mappedBy = "systemRoles")
    @JsonIgnoreProperties(value = {"systemRoles"})
    private Set<SystemUserDO> systemUsers;

    @ManyToMany(targetEntity = SystemResourceDO.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "system_role_resource",
            joinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "mid_resource_id", referencedColumnName = "resource_id")}
    )
    @JsonIgnoreProperties(value = {"systemRoles"})
    private Set<SystemResourceDO> systemResources;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
