package com.github.springbootsecurity.security.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 创建时间为 下午10:39 2020/3/3
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
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class MessageBO implements Serializable {

    private static final long serialVersionUID = -738353368421847075L;

    private String message;

    private LocalDateTime expireTime;

    public MessageBO(String message) {
        this.message = message;
        this.expireTime = LocalDateTime.now().plusSeconds(60);
    }

    public MessageBO(String message, int in) {
        this.message = message;
        this.expireTime = LocalDateTime.now().plusSeconds(in);
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }

}
