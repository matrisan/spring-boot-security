package com.github.springbootsecurity.security.pojo.orm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.springbootsecurity.security.pojo.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午3:22 2020/5/10
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
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "SystemRole", indexes = {
        @Index(name = "IDX_ROLE_CODE", columnList = "role_code", unique = true)
})
public class SystemRoleDO extends BaseEntity implements GrantedAuthority {

    private static final long serialVersionUID = -3157807413812174641L;

    @Column(name = "role_name", columnDefinition = "VARCHAR(100) COMMENT '角色名称'")
    private String roleName;

    @Column(name = "role_code", columnDefinition = "VARCHAR(100) COMMENT '角色编码'")
    private String roleCode;

    @ManyToMany
    private Set<SystemUserDO> users;

//    @ManyToMany
//    private Set<SystemResourceDO> resources;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleCode;
    }
}
