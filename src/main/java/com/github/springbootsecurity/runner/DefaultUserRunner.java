package com.github.springbootsecurity.runner;

import com.github.springbootsecurity.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.pojo.table.SystemUserDO;
import com.github.springbootsecurity.repository.ISystemRoleJpaRepository;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * <p>
 * 创建时间为 下午7:03 2020/3/30
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class DefaultUserRunner implements CommandLineRunner {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISystemUserJpaRepository userJpaRepository;

    @Resource
    private ISystemRoleJpaRepository roleJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        SystemRoleDO rootRole = roleJpaRepository.save(SystemRoleDO.builder().roleName("ROLE_ROOT").build());
        SystemRoleDO userRole = roleJpaRepository.save(SystemRoleDO.builder().roleName("ROLE_USER").build());
        SystemUserDO systemUser1 = SystemUserDO.builder()
                .username("root")
                .password(passwordEncoder.encode("123456"))
                .systemRoles(Collections.singleton(rootRole))
                .email("shaopro@qq.com")
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .note("root")
                .build();
        userJpaRepository.save(systemUser1);
        SystemUserDO systemUser2 = SystemUserDO.builder()
                .username("123456")
                .password(passwordEncoder.encode("123456"))
                .systemRoles(Collections.singleton(userRole))
                .email("shaopro@qq.com")
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .note("user")
                .build();
        userJpaRepository.save(systemUser2);

    }
}
