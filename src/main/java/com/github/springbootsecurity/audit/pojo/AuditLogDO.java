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
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
@Document(collection = "audit_log")
public class AuditLogDO {

    @Id
    private String id;

    private String method;

    @Indexed(name = "IDX_PATH")
    private String path;

    @Indexed(name = "IDX_STATUS")
    private Integer status;

    @Field("request_body")
    private String requestBody;

    @Field("response_body")
    private String responseBody;

    @Field("exception_message")
    private String exceptionMessage;

    @Indexed(name = "IDX_USERNAME")
    private String username;

    @CreatedDate
    @Field("created_date")
    private Date createdDate;

    @LastModifiedDate
    @Field("last_modified_date")
    private Date lastModifiedDate;

}
