package com.github.springbootsecurity.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

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
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2191753221757519036L;

    @JsonIgnore
    private Boolean enabled;

    @JsonIgnore
    private Boolean preset;

    @Version
    @JsonIgnore
    private Long version;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastModifiedDate;

    @CreatedBy
    private SystemUserDO createBy;

    @LastModifiedBy
    private SystemUserDO lastModifiedBy;

}
