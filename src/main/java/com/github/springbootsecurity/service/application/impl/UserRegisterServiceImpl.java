package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.service.application.IUserRegisterService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 下午1:12 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class UserRegisterServiceImpl implements IUserRegisterService {

    @Override
    public SystemUserDO register(SystemUserDO systemUserDO) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

        return null;
    }

}
