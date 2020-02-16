package com.github.springbootsecurity.pojo.doo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 创建时间为 下午2:36 2020/2/14
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
public class SystemUserRegisterDTO implements Serializable {

    private static final long serialVersionUID = -1891575501250542242L;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String email;

    private String note;

}
