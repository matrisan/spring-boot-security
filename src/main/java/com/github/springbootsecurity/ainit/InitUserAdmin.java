package com.github.springbootsecurity.ainit;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import com.google.common.collect.Sets;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Set;

/**
 * <p>
 * 创建时间为 上午10:57 2019/10/21
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@DependsOn("initRole")
@Component
public class InitUserAdmin {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISystemUserJpaRepository repository;

    @PostConstruct
    public void init() {
        repository.deleteAll();
        Set<SystemRoleDO> roleSet = Sets.newHashSet(SystemRoleDO.builder().name("ROLE_ADMIN").note("普通管理员用户").build());
        SystemUserDO systemUserDO = SystemUserDO.builder()
                .username("admin01")
                .password(passwordEncoder.encode("123456"))
                .roles(roleSet)
                .email("shaopro@qq.com")
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .note("admin user")
                .build();
        repository.save(systemUserDO);

    }

}
