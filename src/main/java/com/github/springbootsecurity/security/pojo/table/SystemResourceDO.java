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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
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
@ToString(exclude = {"systemRoles", "childResources", "parentResource"})
@EqualsAndHashCode(callSuper = false, exclude = {"systemRoles", "childResources", "parentResource"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Where(clause = "deleted = false")
@Table(name = "system_resource", indexes = {@Index(columnList = "resource_name", name = "IDX_RESOURCE_NAME")})
@DynamicInsert
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class SystemResourceDO extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1101310665812124141L;

    @Id
    @Column(name = "resource_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    @Column(name = "resource_name", nullable = false, length = 100, columnDefinition = "VARCHAR(100) COMMENT '资源名称'")
    private String resourceName;

    @Column(name = "url", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '资源URL'")
    private String url;

    @Column(name = "method", nullable = false, columnDefinition = "VARCHAR(100) COMMENT '资源请求方式'")
    private String method;

    @Column(name = "resource_note", nullable = false, length = 100, columnDefinition = "VARCHAR(100) COMMENT '资源URL'")
    private String resourceNote;

    @Column(name = "foreign_key_parent_resource_id", insertable = false, updatable = false, columnDefinition = "BIGINT COMMENT '父资源的ID'")
    private Long foreignKeyParentGroupId;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "parentResource")
    @JsonIgnoreProperties(value = {"parentResource", "childResources", "systemRoles"})
    private Set<SystemResourceDO> childResources;

    @ManyToOne(targetEntity = SystemResourceDO.class, cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "foreign_key_parent_resource_id", referencedColumnName = "resource_id")
    @JsonIgnoreProperties(value = {"parentResource", "childResources", "systemRoles"})
    private SystemResourceDO parentResource;

    @ManyToMany(mappedBy = "systemResources", fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"systemResources", "systemGroups", "systemUsers"})
    private Set<SystemRoleDO> systemRoles;

}
