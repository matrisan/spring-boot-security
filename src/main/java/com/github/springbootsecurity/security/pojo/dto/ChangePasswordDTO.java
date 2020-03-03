package com.github.springbootsecurity.security.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

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
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ChangePasswordDTO implements Serializable {

    private static final long serialVersionUID = 511822986645404739L;

    /**
     * 旧密码
     */
    @NotBlank(message = "原密码不能为空")
    private String oldPass;

    /**
     * 新密码
     */
    @NotBlank(message = "新密码不能为空")
    @Length(min = 8, max = 20, message = "8位（含）字符以上，20位（含）字符一下")
    private String newPass1;

    /**
     * 确认新密码
     */
    @NotBlank(message = "确认密码不能为空")
    @Length(min = 8, max = 20, message = "8位（含）字符以上，20位（含）字符一下")
    private String newPass2;


}
