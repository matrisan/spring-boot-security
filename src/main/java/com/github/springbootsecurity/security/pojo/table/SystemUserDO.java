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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
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
import javax.validation.constraints.NotBlank;
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
@ToString(exclude = {"systemRoles"})
@EqualsAndHashCode(exclude = {"systemRoles"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_user", indexes = {@Index(name = "IDX_USERNAME", columnList = "username", unique = true)})
public class SystemUserDO implements UserDetails {

    private static final long serialVersionUID = 6949655530047745714L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String username;

    @NotBlank
    @JsonIgnore
    private String password;

    private String email;

    private String note;

    @JsonIgnore
    private Boolean accountNonExpired;

    @JsonIgnore
    private Boolean accountNonLocked;

    @JsonIgnore
    private Boolean credentialsNonExpired;

    @JsonIgnore
    private Boolean enabled;

    @CreatedDate
    private Date createDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @CreatedBy
    private Long createBy;

    @LastModifiedBy
    private Long lastModifiedBy;


    @ManyToMany(
            targetEntity = SystemRoleDO.class,
            cascade = CascadeType.REFRESH,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "system_user_role",
            joinColumns = {@JoinColumn(name = "mid_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "role_id")}
    )
    @JsonIgnoreProperties(value = {"systemUsers"})
    private Set<SystemRoleDO> systemRoles;

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return systemRoles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
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
