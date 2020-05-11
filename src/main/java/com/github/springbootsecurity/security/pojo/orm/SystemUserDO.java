package com.github.springbootsecurity.security.pojo.orm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.springbootsecurity.security.pojo.BaseEntity;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collection;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_user", indexes = {
        @Index(name = "IDX_USERNAME", columnList = "username", unique = true),
        @Index(name = "IDX_MOBILE", columnList = "mobile", unique = true),
})
public class SystemUserDO extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = 6949655530047745714L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String username;

    @NotBlank
    private String mobile;

    @NotBlank
    @JsonIgnore
    private String password;

    private String email;

    private String note;

    @JsonIgnore
    private LocalDateTime accountNonExpired;

    @JsonIgnore
    private LocalDateTime accountNonLocked;

    @JsonIgnore
    private LocalDateTime credentialsNonExpired;

    private LocalDateTime lastLoginDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Sets.newHashSet(new SimpleGrantedAuthority("ROLE_ROOT"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return LocalDateTime.now().isAfter(accountNonExpired);
    }

    @Override
    public boolean isAccountNonLocked() {
        return LocalDateTime.now().isAfter(accountNonLocked);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return LocalDateTime.now().isAfter(credentialsNonExpired);
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }


}
