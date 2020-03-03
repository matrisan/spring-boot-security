package com.github.springbootsecurity.security.controller.user;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.dto.ChangePasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.PayDTO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * <p>
 * 创建时间为 下午4:04 2020/2/27
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/system/center")
public class SystemCenterController {

    @Resource
    private ISystemUserRepository repository;

    @Resource
    private PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public ResultDTO<SystemUserDO> findGroup(@NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return ResultDTO.success("success", systemUserDO);
    }

    @PutMapping("/user/password")
    public ResultDTO<String> changePassword(@NotNull HttpServletRequest servletRequest,
                                            @NotNull @AuthenticationPrincipal SystemUserDO systemUser,
                                            @NotNull @RequestBody ChangePasswordDTO changePassword) {
        systemUser.setPassword(passwordEncoder.encode(changePassword.getNewPass1()));
        repository.save(systemUser);
        servletRequest.getSession().invalidate();
        return ResultDTO.success();
    }

    @PostMapping("/user/vip")
    public ResultDTO<Void> pay(@RequestBody @Valid PayDTO pay,
                               @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return ResultDTO.success();
    }


}
