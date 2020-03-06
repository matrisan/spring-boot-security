package com.github.springbootsecurity.security.service.common.impl;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.service.common.ICommonRoleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 上午2:15 2020/3/2
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CommonRoleServiceImpl implements ICommonRoleService {

    @Resource
    private ISystemRoleRepository repository;

    @Override
    public Page<SystemRoleDO> findAll(Pageable pageable, @NotNull SystemUserDO authentication) {
        Set<SystemRoleDO> roles = authentication.getSystemGroup().getSystemRoles();
        Set<Long> roleIds = roles.stream().map(SystemRoleDO::getRoleId).collect(Collectors.toSet());
        return repository.findAllByRoleIdIn(roleIds, pageable);
    }

    @Override
    public SystemRoleDO findById(Long roleId) {
        return repository.findById(roleId).orElse(null);
    }

    @Override
    public SystemRoleDO save(@NotNull SystemRoleDO systemRole, @NotNull SystemUserDO authentication) {
        systemRole.setSystemGroups(Collections.singleton(authentication.getSystemGroup()));
        return repository.save(systemRole);
    }

    @Override
    public SystemRoleDO update(SystemRoleDO systemRole, SystemUserDO authentication) {
        return null;
    }

    @Override
    public void deleteById(Long roleId) {

    }
}
