package com.github.springbootsecurity.ainit;

import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
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

//@DependsOn("initRole")
@Component
public class InitUserRoot {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISystemUserJpaRepository repository;

    @PostConstruct
    public void init() {
        Set<GrantedAuthority> authorities = Sets.newHashSet(new SimpleGrantedAuthority("ROLE_ROOT"));
        SystemUserDO systemUser1 = SystemUserDO.builder()
                .username("root")
                .password(passwordEncoder.encode("123456"))
//                .authorities(authorities)
                .email("shaopro@qq.com")
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .note("root user")
                .build();
        repository.save(systemUser1);
        SystemUserDO systemUser2 = SystemUserDO.builder()
                .username("admin")
                .password(passwordEncoder.encode("123456"))
//                .authorities(authorities)
                .email("shaopro@qq.com")
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .note("root user")
                .build();
        systemUser2.getAuthorities().clear();
        Collection<GrantedAuthority> coll = (Collection<GrantedAuthority>) systemUser2.getAuthorities();
        coll.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        repository.save(systemUser2);

    }

}
