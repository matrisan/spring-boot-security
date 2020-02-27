package com.github.springbootsecurity.security.controller.common;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
@RequestMapping("/system/ops")
public class CommonGroupController {

    @Resource
    private ISystemGroupRepository repository;

    @GetMapping("/group")
    public List<SystemGroupDO> findAll(@NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return repository.findAll();
    }

    @GetMapping("/group/{id}")
    @PreAuthorize("@systemAuthorizeServiceImpl.hasSystemGroupPermission('/system/ops/group/*', 'GET', authentication, #id)")
    public SystemGroupDO findById(@PathVariable Long id, @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/group")
    @PreAuthorize("@systemAuthorizeServiceImpl.hasSystemGroupPermission('/system/ops/group', 'POST', authentication)")
    public SystemGroupDO save(@RequestBody SystemGroupDO systemGroup, @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return repository.save(systemGroup);
    }

    @PutMapping("/group")
    @PreAuthorize("@systemAuthorizeServiceImpl.hasSystemGroupPermission('/system/ops/group', 'PUT', authentication)")
    public SystemGroupDO update(@RequestBody SystemGroupDO systemGroup, @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        return repository.save(systemGroup);
    }

    @DeleteMapping("/group/{id}")
    @PreAuthorize("@systemAuthorizeServiceImpl.hasSystemGroupPermission('/system/ops/group/*', 'DELETE', authentication, #id)")
    public void deleteById(@PathVariable Long id, @NotNull @AuthenticationPrincipal SystemUserDO systemUserDO) {
        repository.deleteById(id);
    }

}
