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
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午7:08 2019/9/17
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
@Table(name = "SystemUserDO")
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class SystemUserDO extends BaseEntity implements UserDetails {

    @Transient
    private static final long serialVersionUID = 6949655530047745714L;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '用户名'")
    private String username;

    @Column(columnDefinition = "VARCHAR(20) COMMENT '手机号码'")
    private String mobile;

    @JsonIgnore
    @Column(columnDefinition = "VARCHAR(255) COMMENT '密码'")
    private String password;

    @Column(columnDefinition = "VARCHAR(50) COMMENT '邮箱'")
    private String email;

    @ManyToMany(targetEntity = SystemRoleDO.class, cascade = {CascadeType.REFRESH})
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<SystemRoleDO> roles;

    @JsonIgnore
    @Column(name = "account_non_expired", columnDefinition = "VARCHAR(100) COMMENT '用户备注'")
    private Date accountNonExpired;

    @JsonIgnore
    @Column(name = "account_non_locked", columnDefinition = "VARCHAR(100) COMMENT '用户备注'")
    private Date accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", columnDefinition = "VARCHAR(100) COMMENT '用户备注'")
    private Date credentialsNonExpired;

    @JsonIgnore
    @Column(name = "last_login_date", columnDefinition = "VARCHAR(100) COMMENT '用户备注'")
    private Date lastLoginDate;

    @JsonIgnore
    @Override
    public Collection<SystemRoleDO> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

}
