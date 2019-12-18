package com.github.springbootsecurity.audit.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * <p>
 * 创建时间为 下午1:25 2019/12/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "AuditLogO")
public class AuditLogDO {

    @Id
    private String id;

    private String method;

    private String path;

    private Integer status;

    private String requestBody;

    private String responseBody;

    private String username;

    @CreatedDate
    private Date createdTime;

    @LastModifiedDate
    private Date modifyTime;

}
