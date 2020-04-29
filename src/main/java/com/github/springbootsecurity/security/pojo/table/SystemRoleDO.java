package com.github.springbootsecurity.security.pojo.table;

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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午7:10 2020/3/30
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
@ToString(exclude = {"systemUsers"})
@EqualsAndHashCode(exclude = {"systemUsers"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "system_role", indexes = {@Index(name = "IDX_ROLE_NAME", columnList = "role_id", unique = true)})
public class SystemRoleDO implements GrantedAuthority {

    private static final long serialVersionUID = 5924766574673614541L;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, mappedBy = "systemRoles")
    @JsonIgnoreProperties(value = {"systemRoles"})
    private Set<SystemUserDO> systemUsers;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
