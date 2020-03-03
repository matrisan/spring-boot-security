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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午7:59 2020/2/17
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
@ToString(exclude = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
@AllArgsConstructor
@Entity
@Where(clause = "deleted = false")
@Table(name = "system_group", indexes = {@Index(columnList = "group_name", name = "IDX_GROUP_NAME")})
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class SystemGroupDO extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3948719216778809688L;

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(name = "group_name", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '组织架构名称'")
    private String groupName;

    @Column(name = "group_note", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '组织架构备注'")
    private String groupNote;

    @Column(name = "foreign_key_parent_group_id", insertable = false, updatable = false, columnDefinition = "BIGINT COMMENT '组织架构父节点 ID'")
    private Long foreignKeyParentGroupId;

    @ManyToOne(targetEntity = SystemGroupDO.class, cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "foreign_key_parent_group_id", referencedColumnName = "group_id")
    @JsonIgnoreProperties(value = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
    private SystemGroupDO parentGroup;

    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "parentGroup")
    @JsonIgnoreProperties(value = {"childGroup", "parentGroup", "systemRoles", "systemUsers"})
    private Set<SystemGroupDO> childGroup;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "systemGroups")
    @JsonIgnoreProperties(value = {"systemGroups", "systemUsers", "systemResources"})
    private Set<SystemRoleDO> systemRoles;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "systemGroup")
    @JsonIgnoreProperties(value = {"systemGroup", "systemRoles"})
    private Set<SystemUserDO> systemUsers;
}
