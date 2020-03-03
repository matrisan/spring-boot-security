package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.service.ICommonRoleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

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
    public Page<SystemRoleDO> findAll(Pageable pageable, SystemUserDO authentication) {
        return null;
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
