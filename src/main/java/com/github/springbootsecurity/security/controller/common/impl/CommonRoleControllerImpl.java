package com.github.springbootsecurity.security.controller.common.impl;

import com.github.springbootsecurity.security.controller.common.ICommonRoleController;
import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.service.common.ICommonRoleService;
import com.github.springbootsecurity.security.validation.group.Save;
import com.github.springbootsecurity.security.validation.group.Update;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午8:01 2020/2/17
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
public class CommonRoleControllerImpl implements ICommonRoleController {

    @Resource
    private ICommonRoleService service;

    @GetMapping("/role")
    @Override
    public ResultDTO<Page<SystemRoleDO>> findAll(@NotNull @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                                 @NotNull @AuthenticationPrincipal SystemUserDO authentication) {
        return ResultDTO.success(service.findAll(pageable, authentication));
    }

    @PreAuthorize("@authorizeRoleService.hasRolePermission(authentication,#roleId)")
    @GetMapping("/role/{roleId}")
    @Override
    public ResultDTO<SystemRoleDO> findById(@PathVariable Long roleId) {
        return ResultDTO.success(service.findById(roleId));
    }

    @PostMapping("/role")
    @Override
    public ResultDTO<SystemRoleDO> save(@NotNull @Validated({Save.class}) @RequestBody SystemRoleDO systemRole,
                                        @NotNull @AuthenticationPrincipal SystemUserDO authentication) {
        return ResultDTO.success(service.save(systemRole, authentication));
    }

    @PreAuthorize("@authorizeRoleService.hasRolePermission(authentication,#systemRole.getRoleId())")
    @PutMapping("/role")
    @Override
    public ResultDTO<SystemRoleDO> update(@NotNull @Validated({Update.class}) @RequestBody SystemRoleDO systemRole,
                                          @NotNull @AuthenticationPrincipal SystemUserDO authentication) {
        return ResultDTO.success(service.save(systemRole, authentication));
    }


    @PreAuthorize("@authorizeRoleService.hasRolePermission(authentication,#roleId)")
    @DeleteMapping("/role/{roleId}")
    @Override
    public ResultDTO<Void> deleteById(@PathVariable Long roleId) {
        service.deleteById(roleId);
        return ResultDTO.success();
    }

}
