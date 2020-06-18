package com.github.springbootsecurity.security.initializer;

import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.repository.IRoleRepository;
import com.github.springbootsecurity.security.repository.IUserRepository;
import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

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

    private final IUserRepository userRepository;

    private final IRoleRepository roleRepository;

    @Override
    public void run(String... args) {
        SystemRoleDO role = roleRepository.save(getRole());
        SystemUserDO user = getUser();
        user.setRoles(Sets.newHashSet(role));
        userRepository.save(user);
    }

    private SystemRoleDO getRole() {
        return SystemRoleDO.builder().roleName("超管").roleCode("ROLE_ROOT").build();
    }

    private SystemUserDO getUser() {
        return SystemUserDO.builder().username("root").mobile("18812345678").password(("123456")).build();
    }

}
