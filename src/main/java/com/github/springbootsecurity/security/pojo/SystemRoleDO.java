package com.github.springbootsecurity.security.pojo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午10:23 2019/12/3
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
//@Entity
@EqualsAndHashCode
//@Table(name = "system_role")
public class SystemRoleDO implements GrantedAuthority {

    private static final long serialVersionUID = 2604553394364576002L;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;

    @ManyToMany(targetEntity = SystemUserDO.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "system_user_role",
            joinColumns = {@JoinColumn(name = "system_role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "system_user_id", referencedColumnName = "user_id")}
    )
    private Set<SystemUserDO> users;

}
