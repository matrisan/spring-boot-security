package com.github.springbootsecurity.init;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

/**
 * <p>
 * 创建时间为 上午1:57 2020/2/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

//@Component
public class InitUser {

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemRoleRepository roleRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        boolean contain = userRepository.findAll().stream()
                .anyMatch(systemUserDO -> StringUtils.equalsIgnoreCase(systemUserDO.getUsername(), "root"));
        if (!contain) {
            createUser();
        }
    }


    private void createUser() {
        initRoot("user", "123456", "ROLE_USER");
    }


    private void initRoot(String username, String password, String roleName) {
        SystemRoleDO systemRole = SystemRoleDO.builder()
                .roleName(roleName)
                .note(roleName)
                .build();
        roleRepository.save(systemRole);
        SystemRoleDO newRole = new SystemRoleDO();
        BeanUtils.copyProperties(systemRole, newRole);
        SystemUserDO systemUser = SystemUserDO.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .note("")
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .systemRoles(Collections.singleton(systemRole))
                .build();
        userRepository.save(systemUser);
    }

}
