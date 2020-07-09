package com.github.springbootsecurity.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.springbootsecurity.security.converter.MobileMosaicConverter;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 创建时间为 下午3:30 2020/5/10
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
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Transient
    private static final long serialVersionUID = -2191753221757519036L;

    @Column(columnDefinition = "VARCHAR(100) COMMENT '备注'")
    private String note;

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '是否为预置'")
    private Boolean preset;

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 1 COMMENT '是否启用'")
    private Boolean enabled;

    @JsonIgnore
    @Column(columnDefinition = "INT(1) DEFAULT 0 COMMENT '改记录是否删除'")
    private Boolean deleted;

    @JsonIgnore
    @Version
    @Column(columnDefinition = "BIGINT DEFAULT 0 COMMENT '改记录是否删除'")
    private Long version;

    @CreatedDate
    @Column(name="create_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @LastModifiedDate
    @Column(name="last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastModifiedDate;

    @CreatedBy
    @Column(name="create_by")
    @Convert(converter = MobileMosaicConverter.class)
    private String createBy;

    @LastModifiedBy
    @Column(name="last_modified_by")
    @Convert(converter = MobileMosaicConverter.class)
    private String lastModifiedBy;

}
