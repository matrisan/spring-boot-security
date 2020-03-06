package com.github.springbootsecurity.security.service.common.impl;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
import com.github.springbootsecurity.security.service.common.ICommonResourceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午3:14 2020/3/4
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CommonResourceServiceImpl implements ICommonResourceService {

    @Resource
    private ISystemResourceRepository repository;

    @Override
    public Page<SystemResourceDO> findAll(Pageable pageable, @NotNull SystemUserDO authentication) {
        Set<Long> resourceIds = authentication.getSystemRoles().stream()
                .flatMap(one -> one.getSystemResources().stream())
                .map(SystemResourceDO::getResourceId)
                .collect(Collectors.toSet());
        return repository.findAllByResourceIdIn(resourceIds, pageable);
    }

    @Override
    public SystemResourceDO findById(Long resourceId) {
        return repository.findById(resourceId).orElse(null);
    }
}
