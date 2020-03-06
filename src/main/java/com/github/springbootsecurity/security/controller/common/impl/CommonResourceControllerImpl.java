package com.github.springbootsecurity.security.controller.common.impl;

import com.github.springbootsecurity.security.controller.common.ICommonResourceController;
import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.service.common.ICommonResourceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CommonResourceControllerImpl implements ICommonResourceController {

    @Resource
    private ICommonResourceService service;

    @GetMapping("/resource")
    @Override
    public ResultDTO<Page<SystemResourceDO>> findAll(@NotNull @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                                     @NotNull @AuthenticationPrincipal SystemUserDO authentication) {
        return ResultDTO.success(service.findAll(pageable, authentication));
    }

    @PreAuthorize("@authorizeResourceService.hasResourcePermission(authentication, #resourceId)")
    @GetMapping("/resource/{resourceId}")
    @Override
    public ResultDTO<SystemResourceDO> findById(@PathVariable Long resourceId) {
        return ResultDTO.success(service.findById(resourceId));
    }

}
