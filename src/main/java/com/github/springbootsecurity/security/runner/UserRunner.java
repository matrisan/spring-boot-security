package com.github.springbootsecurity.security.runner;

import com.github.springbootsecurity.security.pojo.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * <p>
 * 创建时间为 下午4:34 2020/2/20
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class UserRunner implements CommandLineRunner {

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemRoleRepository roleRepository;

    @Resource
    private PasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        SystemRoleDO systemRole1 = SystemRoleDO.builder().roleName("ROLE_ROOT").note("ROOT 用户!").build();
        roleRepository.save(systemRole1);
        SystemRoleDO systemRole2 = SystemRoleDO.builder()
                .roleId(systemRole1.getRoleId())
                .build();
        SystemUserDO systemUser = SystemUserDO.builder()
                .username("root")
                .password(encoder.encode("shaodong"))
                .systemRoles(Collections.singleton(systemRole2))
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        userRepository.save(systemUser);
    }
}
