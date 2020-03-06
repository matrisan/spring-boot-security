package com.github.springbootsecurity.security.service.user;

import com.github.springbootsecurity.security.pojo.dto.PasswordRetrieveDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;

/**
 * <p>
 * 创建时间为 下午1:58 2020/2/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ISystemMaintainService {

    String register(UserRegisterDTO userRegister);

    String forget(String mode, String username);

    String retrieve(String random, PasswordRetrieveDTO retrieve);


}
