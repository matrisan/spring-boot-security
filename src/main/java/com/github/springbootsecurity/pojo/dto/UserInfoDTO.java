package com.github.springbootsecurity.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 * 创建时间为 下午7:08 2019/9/17
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
@AllArgsConstructor
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 1983404876091320448L;

    private String id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String email;

    @Singular
    private Collection<GrantedAuthority> authorities;

    private String desc;

}
