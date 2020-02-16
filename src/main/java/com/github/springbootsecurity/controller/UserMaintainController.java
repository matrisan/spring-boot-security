package com.github.springbootsecurity.controller;

import com.github.springbootsecurity.pojo.doo.SystemUserChangePasswordDTO;
import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("user")
@PreAuthorize("isAuthenticated()")
public class UserMaintainController {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISystemUserJpaRepository repository;

    @PostMapping("maintain")
    public String changePassword(@NotNull HttpServletRequest servletRequest,
                                 @NotNull @AuthenticationPrincipal SystemUserDO systemUser,
                                 @NotNull @Validated @RequestBody SystemUserChangePasswordDTO systemUserChangePassword) {
        boolean match = passwordEncoder.matches(systemUserChangePassword.getPasswordOld(), systemUser.getPassword());

        if (match) {
            systemUser.setPassword(passwordEncoder.encode(systemUserChangePassword.getPasswordNew()));
            repository.save(systemUser);
            servletRequest.getSession().invalidate();
            return "修改成功!";
        }
        return "修改失败!";
    }

}
