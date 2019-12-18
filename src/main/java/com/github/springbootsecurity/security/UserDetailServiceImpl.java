package com.github.springbootsecurity.security;


import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.doo.SystemUserDO;
//import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

/**
 * <p>
 * 创建时间为 下午8:35 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private PasswordEncoder passwordEncoder = createDelegatingPasswordEncoder();

    private static final Map<String, SystemUserDO> MAP = Maps.newHashMap();

    {
        MAP.put("root", SystemUserDO.builder()
                .username("root")
                .password(passwordEncoder.encode("123456"))
                .authorities(Sets.newHashSet(SystemRoleDO.builder().authority("ROLE_ROOT").build()))
                .email("shaopro@qq.com")
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .note("root user")
                .build());
        MAP.put("admin", SystemUserDO.builder()
                .username("admin")
                .password(passwordEncoder.encode("123456"))
                .authorities(Sets.newHashSet(SystemRoleDO.builder().authority("ROLE_ADMIN").build()))
                .email("shaopro@qq.com")
                .credentialsNonExpired(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .note("admin user")
                .build());
    }

    @SneakyThrows(UsernameNotFoundException.class)
    @Override
    public UserDetails loadUserByUsername(String username) {
        SystemUserDO systemUserDO = MAP.get(username);
        if (null == systemUserDO) {
            throw new UsernameNotFoundException(username);
        }
        return systemUserDO;
    }

}
