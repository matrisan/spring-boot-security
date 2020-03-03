package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.github.springbootsecurity.security.service.ISystemMaintainService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * <p>
 * 创建时间为 下午2:09 2020/2/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SystemMaintainServiceImpl implements ISystemMaintainService {

    @Resource
    private ISystemGroupRepository systemGroupRepository;

    @Resource
    private ISystemUserRepository systemUserRepository;

    @Resource
    private ISystemRoleRepository systemRoleRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(UserRegisterDTO userRegister) {
        SystemGroupDO systemGroup = getSystemGroup(userRegister);
        SystemUserDO systemUser = getSystemUser(userRegister);
        systemUser.setSystemGroup(systemGroupRepository.save(systemGroup));
        systemUserRepository.save(systemUser);
        return "success!";
    }

    private SystemGroupDO getSystemGroup(@NotNull UserRegisterDTO userRegister) {
        SystemRoleDO systemRole = systemRoleRepository.findByRoleNameEquals("ROLE_VIP").orElse(new SystemRoleDO());
        return SystemGroupDO.builder()
                .groupName(userRegister.getGroupName())
                .systemRoles(Collections.singleton(systemRole))
                .groupNote(userRegister.getGroupNote())
                .build();
    }

    private SystemUserDO getSystemUser(@NotNull UserRegisterDTO userRegister) {
        SystemRoleDO systemRole = systemRoleRepository.findByRoleNameEquals("ROLE_VIP").orElse(new SystemRoleDO());
        return SystemUserDO.builder()
                .username(userRegister.getUsername())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .phone(userRegister.getPhone())
                .systemRoles(Collections.singleton(systemRole))
                .userNote(userRegister.getUserNote())
                .build();
    }

}
