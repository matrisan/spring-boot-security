package com.github.springbootsecurity.security.controller.user;

import com.github.springbootsecurity.security.pojo.dto.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/system/common")
public class UserCenterController {

    @GetMapping("/center")
    public ResultDTO<SystemUserDO> findGroup(@NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return ResultDTO.success("success", systemUserDO);
    }


}
