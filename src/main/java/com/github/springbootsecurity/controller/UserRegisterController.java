package com.github.springbootsecurity.controller;

import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.pojo.doo.SystemUserRegisterDTO;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午2:34 2020/2/14
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@RequestMapping("/user")
@PreAuthorize("permitAll()")
public class UserRegisterController {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISystemUserJpaRepository repository;

    @PostMapping("/register")
    public SystemUserRegisterDTO register(@NotNull @RequestBody @Validated SystemUserRegisterDTO register) {
        String password = passwordEncoder.encode(register.getPassword());
        register.setPassword(password);
        SystemUserDO systemUser = new SystemUserDO();
        BeanUtils.copyProperties(register, systemUser);
        systemUser.setAccountNonExpired(true);
        systemUser.setAccountNonLocked(true);
        systemUser.setCredentialsNonExpired(true);
        systemUser.setEnabled(true);
        repository.save(systemUser);
        return register;
    }


}
