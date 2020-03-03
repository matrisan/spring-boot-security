package com.github.springbootsecurity.security.pojo.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * <p>
 * 创建时间为 下午3:01 2020/2/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '改记录是否删除'")
    private Boolean deleted;

    @JsonIgnore
    @CreatedDate
    @Column(name = "create_date", columnDefinition = "DATETIME COMMENT '创建时间'")
    private Date createDate;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "last_modified_date", columnDefinition = "DATETIME COMMENT '最后更新时间'")
    private Date lastModifiedDate;

    @JsonIgnore
    @CreatedBy
    @Column(name = "create_by", columnDefinition = "VARCHAR(100) COMMENT '创建人'")
    private String createBy;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "last_modified_by", columnDefinition = "VARCHAR(100) COMMENT '最后更新人'")
    private String lastModifiedBy;

}
