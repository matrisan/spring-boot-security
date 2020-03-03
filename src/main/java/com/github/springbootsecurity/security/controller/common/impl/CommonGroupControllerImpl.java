package com.github.springbootsecurity.security.controller.common.impl;

import com.github.springbootsecurity.security.controller.common.ICommonGroupController;
import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.service.ICommonGroupService;
import com.github.springbootsecurity.security.validated.Save;
import com.github.springbootsecurity.security.validated.Update;
import org.jetbrains.annotations.NotNull;
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
public class CommonGroupControllerImpl implements ICommonGroupController {

    @Resource
    private ICommonGroupService service;

    @PreAuthorize("@authorizeGroupService.hasGroupPermission(authentication,#groupId)")
    @GetMapping("/group/{groupId}")
    @Override
    public ResultDTO<SystemGroupDO> findById(@PathVariable Long groupId) {
        return ResultDTO.success(service.findById(groupId));
    }

    @PostMapping("/group")
    @Override
    public ResultDTO<SystemGroupDO> save(@NotNull @Validated({Save.class}) @RequestBody SystemGroupDO systemGroup,
                                         @NotNull @AuthenticationPrincipal SystemUserDO authentication) {
        return ResultDTO.success(service.save(systemGroup, authentication));
    }

    @PreAuthorize("@authorizeGroupService.hasGroupPermission(authentication,#systemGroup.getGroupId())")
    @PutMapping("/group")
    @Override
    public ResultDTO<SystemGroupDO> update(@NotNull @Validated({Update.class}) @RequestBody SystemGroupDO systemGroup,
                                           @NotNull @AuthenticationPrincipal SystemUserDO authentication) {
        return ResultDTO.success(service.update(systemGroup, authentication));
    }

    @PreAuthorize("@authorizeGroupService.hasGroupPermission(authentication, #groupId)")
    @DeleteMapping("/group/{groupId}")
    @Override
    public ResultDTO<Void> deleteById(@PathVariable Long groupId) {
        service.deleteById(groupId);
        return ResultDTO.success();
    }

}
