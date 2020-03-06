package com.github.springbootsecurity.security.service.common.impl;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.github.springbootsecurity.security.service.common.ICommonUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午3:03 2020/3/4
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CommonUserServiceImpl implements ICommonUserService {

    @Resource
    private ISystemUserRepository userRepository;

    @Override
    public Page<SystemUserDO> findAll(Pageable pageable, @NotNull SystemUserDO authentication) {
        Set<Long> userIds = authentication.getSystemGroup().getSystemUsers().stream()
                .map(SystemUserDO::getUserId).collect(Collectors.toSet());
        return userRepository.findAllByUserIdIn(userIds, pageable);
    }

    @Override
    public SystemUserDO findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public SystemUserDO save(@NotNull SystemUserDO systemUser, @NotNull SystemUserDO authentication) {
        SystemGroupDO systemGroup = authentication.getSystemGroup();
        systemUser.setSystemGroup(systemGroup);
        return userRepository.save(systemUser);
    }

    @Override
    public SystemUserDO update(@NotNull SystemUserDO systemUser, @NotNull SystemUserDO authentication) {
        SystemGroupDO systemGroup = authentication.getSystemGroup();
        systemUser.setSystemGroup(systemGroup);
        return userRepository.save(systemUser);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
