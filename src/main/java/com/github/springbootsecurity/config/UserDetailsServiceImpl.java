package com.github.springbootsecurity.config;

import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午3:45 2020/2/14
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
    private ISystemUserJpaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findSystemUserDOByUsername(username);
    }
}
