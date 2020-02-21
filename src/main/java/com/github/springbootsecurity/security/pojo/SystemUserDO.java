package com.github.springbootsecurity.security.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@ToString(exclude = {"systemRoles"})
@EqualsAndHashCode(callSuper = false, exclude = {"systemRoles"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
//@Where(clause = "deleted = false")
@Table(name = "system_user", indexes = {@Index(columnList = "username", name = "IDX_USERNAME")})
public class SystemUserDO extends BaseEntity implements UserDetails, Serializable {

    private static final long serialVersionUID = 7779871865149295381L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) COMMENT '用户名'")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) COMMENT '密码'")
    private String password;

    @Column(name = "account_expired_date", columnDefinition = "DATETIME COMMENT '账号过期时间'")
    private Date accountExpiredDate;

    @Column(name = "account_non_locked", columnDefinition = "INT(1) DEFAULT 0 COMMENT '账号没有被锁定'")
    private Boolean accountNonLocked;

    @Column(name = "credentials_non_expired", columnDefinition = "INT(1) DEFAULT 0 COMMENT '凭证没有过期'")
    private Boolean credentialsNonExpired;

    @Column(name = "enabled", columnDefinition = "INT(1) DEFAULT 0 COMMENT '账号启用'")
    private Boolean enabled;

    @ManyToMany(
            targetEntity = SystemRoleDO.class,
            cascade = {CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "system_role_user",
            joinColumns = {@JoinColumn(name = "mid_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "role_id")}
    )
    @JsonIgnoreProperties(value = {"systemUsers"})
    private Set<SystemRoleDO> systemRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return systemRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        if (null == accountExpiredDate) {
            return true;
        }
        return accountExpiredDate.after(new Date());
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
