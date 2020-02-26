package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.pojo.SystemRoleDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

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
public class InitRole {

    @Resource
    private ISystemRoleRepository roleRepository;

    @PostConstruct
    public void init() {
        SystemRoleDO systemRole = SystemRoleDO.builder()
                .roleName("ROLE_ROOT")
                .note("root")
                .build();
        roleRepository.save(systemRole);
    }

}
