package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * <p>
 * 创建时间为 下午2:31 2020/2/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
@DependsOn("initializeRole")
public class InitializeUser implements CommandLineRunner {

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemRoleRepository roleRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsernameEquals("root")) {
            SystemRoleDO systemRole = roleRepository.findByRoleNameEquals("ROLE_ROOT");
            SystemUserDO systemUser = creatRootUser();
            systemUser.setSystemRoles(Collections.singleton(systemRole));
            userRepository.save(systemUser);
        }
    }


    private SystemUserDO creatRootUser() {
        return SystemUserDO.builder().username("root").password(passwordEncoder.encode("123456")).phone("").note("root 用户").build();
    }


}
