package com.github.springbootsecurity.security.config;

import com.github.springbootsecurity.security.pojo.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.google.common.collect.Maps;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 下午8:13 2020/2/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private ISystemUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUserDO> optional = userRepository.findSystemUserDOByUsername(username);
        return optional.orElse(new SystemUserDO());
    }

//    @NotNull
//    private Map<String, UserDetails> userDetails() {
//        Map<String, UserDetails> map = Maps.newHashMap();
//        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ROOT");
//        UserDO user = new UserDO();
//        user.setId(0L);
//        user.setUsername("root");
//        user.setPassword(passwordEncoder.encode("123456"));
//        user.setAuthorities(Collections.singleton(authority));
//        map.put("root", user);
//        return map;
//    }

}
