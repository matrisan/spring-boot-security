package com.github.springbootsecurity.security.pojo.dto;

import com.github.springbootsecurity.security.constraint.UniqueMobile;
import com.github.springbootsecurity.security.constraint.UniqueUsername;
import lombok.Data;

/**
 * @author 石少东
 * @date 2020-06-16 17:12
 */


@Data
public class UserRegisterDTO {

    @UniqueUsername
    private String username;

    private String password;

    @UniqueMobile
    private String mobile;

    private String email;

    private String note;

}
