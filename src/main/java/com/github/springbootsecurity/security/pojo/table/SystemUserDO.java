package com.github.springbootsecurity.security.pojo.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
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
@ToString(exclude = {"systemGroup", "systemRoles"})
@EqualsAndHashCode(callSuper = false, exclude = {"systemGroup", "systemRoles"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "deleted = false or deleted is null")
@Table(name = "system_user", indexes = {@Index(columnList = "username", name = "IDX_USERNAME")})
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class SystemUserDO extends BaseEntity implements UserDetails, Serializable {

    private static final long serialVersionUID = 7779871865149295381L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) COMMENT '用户名'")
    private String username;

    @JsonIgnore
    @Column(nullable = false, columnDefinition = "VARCHAR(100) COMMENT '密码'")
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(100) COMMENT '用户手机号码'")
    private String phone;

    @Column(name = "user_note", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '用户备注'")
    private String userNote;

    @Column(name = "account_expired_date", columnDefinition = "DATETIME COMMENT '账号过期时间'")
    private Date accountExpiredDate;

    @JsonIgnore
    @Column(name = "account_non_locked", nullable = false, columnDefinition = "INT(1) DEFAULT 1 COMMENT '账号没有被锁定'")
    private Boolean accountNonLocked;

    @JsonIgnore
    @Column(name = "credentials_non_expired", nullable = false, columnDefinition = "INT(1) DEFAULT 1 COMMENT '凭证没有过期'")
    private Boolean credentialsNonExpired;

    @JsonIgnore
    @Column(name = "enabled", nullable = false, columnDefinition = "INT(1) DEFAULT 1 COMMENT '账号启用'")
    private Boolean enabled;

    @Column(name = "foreign_key_group_id", insertable = false, updatable = false, columnDefinition = "BIGINT COMMENT '组织架构ID'")
    private Long foreignKeyGroupId;

    @ManyToOne(
            targetEntity = SystemGroupDO.class,
            cascade = {CascadeType.REFRESH},
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "foreign_key_group_id", referencedColumnName = "group_id")
    @JsonIgnoreProperties(value = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
    private SystemGroupDO systemGroup;

    @ManyToMany(
            targetEntity = SystemRoleDO.class,
            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "system_role_user",
            joinColumns = {@JoinColumn(name = "mid_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "role_id")}
    )
    @JsonIgnoreProperties(value = {"systemUsers", "systemGroups", "systemResources"})
    private Set<SystemRoleDO> systemRoles;

    @JsonIgnore
    @Override
    public Collection<SystemRoleDO> getAuthorities() {
        return systemRoles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        if (null == accountExpiredDate) {
            return true;
        }
        return accountExpiredDate.after(new Date());
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public SystemUserDO addVipRole(SystemRoleDO systemRole) {
        this.setSystemRoles(Collections.singleton(systemRole));
        return this;
    }

    public SystemUserDO addCommonRole(SystemRoleDO systemRole) {
        this.systemRoles.add(systemRole);
        return this;
    }

    public SystemUserDO renew(int count) {
        Date date = new DateTime(accountExpiredDate.getTime()).plusMonths(count).toDate();
        this.setAccountExpiredDate(date);
        return this;
    }

}
