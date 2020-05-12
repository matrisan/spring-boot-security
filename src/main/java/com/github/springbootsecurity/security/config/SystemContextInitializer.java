package com.github.springbootsecurity.security.config;

import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleJpaRepository;
import com.github.springbootsecurity.security.repository.ISystemUserJpaRepository;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 * 创建时间为 下午4:47 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Order(1)
@Configuration
@RequiredArgsConstructor
public class SystemContextInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final ISystemUserJpaRepository userRepository;

    private final ISystemRoleJpaRepository roleRepository;

    @Override
    public void run(String... args) {
        SystemRoleDO role = roleRepository.save(getRole());
        SystemUserDO user = getUser();
        user.setRoles(Sets.newHashSet(role));
        userRepository.save(user);
    }

    private SystemRoleDO getRole() {
        SystemRoleDO role = SystemRoleDO.builder()
                .roleName("超管")
                .roleCode("ROLE_ROOT")
                .build();
        return role;
    }

    private SystemUserDO getUser() {
        SystemUserDO user = SystemUserDO.builder()
                .username("root")
                .password(passwordEncoder.encode("123456"))
                .build();
        return user;
    }

}
