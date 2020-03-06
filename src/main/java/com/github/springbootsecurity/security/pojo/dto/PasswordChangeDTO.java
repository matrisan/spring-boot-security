package com.github.springbootsecurity.security.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 创建时间为 上午10:51 2020/2/28
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class PasswordChangeDTO extends PasswordRetrieveDTO implements Serializable {

    private static final long serialVersionUID = 511822986645404739L;

    /**
     * 旧密码
     */
    @NotBlank(message = "原密码不能为空")
    private String oldPass;

}
