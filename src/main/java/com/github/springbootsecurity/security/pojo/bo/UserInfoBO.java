package com.github.springbootsecurity.security.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 石少东
 * @date 2020-07-09 15:28
 * @since 1.0
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoBO {

    private Long id;

    private String username;

    private String mobile;

    private String password;

    private String email;

}
