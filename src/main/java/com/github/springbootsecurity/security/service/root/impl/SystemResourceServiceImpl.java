package com.github.springbootsecurity.security.service.root.impl;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
import com.github.springbootsecurity.security.service.root.ISystemResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午9:43 2020/2/24
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SystemResourceServiceImpl implements ISystemResourceService {

    @Resource
    private ISystemResourceRepository repository;

    @Override
    public List<SystemResourceDO> findAllResource() {
        return repository.findAll();
    }

    @Override
    public SystemResourceDO findOneByUrlAndMethod(String url, String method) {
        return repository.findByUrlEqualsAndMethodEquals(url,method).orElse(new SystemResourceDO());
    }
}
