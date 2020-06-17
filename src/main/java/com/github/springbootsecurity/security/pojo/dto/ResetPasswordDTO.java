package com.github.springbootsecurity.security.pojo.dto;

import lombok.Data;

/**
 * @author 石少东
 * @date 2020-06-16 17:16
 */

@Data
public class ResetPasswordDTO {

    private String passwordOld;

    private String passwordNew1;

    private String passwordNew2;

}
