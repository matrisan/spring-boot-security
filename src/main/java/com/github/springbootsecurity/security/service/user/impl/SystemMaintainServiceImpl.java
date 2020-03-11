package com.github.springbootsecurity.security.service.user.impl;

import com.github.springbootsecurity.security.manager.AbstractForgetManager;
import com.github.springbootsecurity.security.pojo.bo.MessageBO;
import com.github.springbootsecurity.security.pojo.dto.PasswordRetrieveDTO;
import com.github.springbootsecurity.security.pojo.dto.RetrieveDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.github.springbootsecurity.security.service.user.ISystemMaintainService;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.joda.time.DateTime;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

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

    @Resource
    private Map<String, AbstractForgetManager> forgetManager;

    @Override
    public String register(UserRegisterDTO userRegister) {
        SystemGroupDO systemGroup = getSystemGroup(userRegister);
        SystemUserDO systemUser = getSystemUser(userRegister);
        systemUser.setSystemGroup(systemGroupRepository.save(systemGroup));
        systemUserRepository.save(systemUser);
        return "success!";
    }

    @Override
    public String retrieve(String type, @NotNull RetrieveDTO retrieve) {
        Optional<SystemUserDO> optional = systemUserRepository.findByUsernameEquals(retrieve.getUsername());
        optional.ifPresent(systemUser -> {
            AbstractForgetManager forgetEntity = forgetManager.get(type);
            MessageBO message = forgetEntity.createAuthCode(systemUser);
            tempUserInfo(systemUser, message);
            forgetEntity.sentMessage(systemUser, message);
        });
        return "success";
    }


    @Override
    public String retrieve(String random, PasswordRetrieveDTO retrieve) {
        return null;
    }

    private SystemGroupDO getSystemGroup(@NotNull UserRegisterDTO userRegister) {
        SystemRoleDO systemRole = systemRoleRepository.findByRoleNameEquals("ROLE_TRIAL").orElse(new SystemRoleDO());
        return SystemGroupDO.builder()
                .groupName(userRegister.getGroupName())
                .systemRoles(Collections.singleton(systemRole))
                .groupNote(userRegister.getGroupNote())
                .build();
    }

    private SystemUserDO getSystemUser(@NotNull UserRegisterDTO userRegister) {
        SystemRoleDO systemRole = systemRoleRepository.findByRoleNameEquals("ROLE_TRIAL").orElse(new SystemRoleDO());
        return SystemUserDO.builder()
                .username(userRegister.getUsername())
                .password(passwordEncoder.encode(userRegister.getPassword()))
                .phone(userRegister.getPhone())
                .systemRoles(Collections.singleton(systemRole))
                .accountExpiredDate(DateTime.now().plusDays(30).toDate())
                .userNote(userRegister.getUserNote())
                .build();
    }

    private void tempUserInfo(SystemUserDO systemUser, MessageBO message) {
        // TODO
        // 存储到缓存或者数据库中
    }


    @NotNull
    private MessageBO getRandomString(SystemUserDO systemUser) {
        return new MessageBO(RandomStringUtils.randomAlphanumeric(30));
    }
}
