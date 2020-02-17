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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@EqualsAndHashCode(exclude = {"systemGroup", "systemRoles"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_user")
public class SystemUserDO {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    private String username;

    @Column(name = "foreign_key_group_id", insertable = false, updatable = false)
    private Long foreignKeyGroupId;

    @ManyToOne(
            targetEntity = SystemGroupDO.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "foreign_key_group_id", referencedColumnName = "group_id")
    @JsonIgnoreProperties(value = {"childGroup","parentGroup","systemRoles","systemUsers"})
    private SystemGroupDO systemGroup;


    @ManyToMany(targetEntity = SystemRoleDO.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "system_role_user",
            joinColumns = {@JoinColumn(name = "mid_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "mid_role_id", referencedColumnName = "role_id")}
    )
    @JsonIgnoreProperties(value = {"systemUsers", "systemGroups"})
    private Set<SystemRoleDO> systemRoles;

}
