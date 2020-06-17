package com.github.springbootsecurity.security.pojo.dto;

import com.github.springbootsecurity.security.constraint.Password;
import com.github.springbootsecurity.security.constraint.ResetPassword;
import lombok.Data;

/**
 * @author 石少东
 * @date 2020-06-16 17:16
 */

@Data
@ResetPassword
public class ResetPasswordDTO {

    @Password
    private String passwordOld;

    private String passwordNew1;

    private String passwordNew2;

}
