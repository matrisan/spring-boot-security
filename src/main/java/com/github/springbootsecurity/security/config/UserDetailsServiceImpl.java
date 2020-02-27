package com.github.springbootsecurity.security.config;

import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private ISystemUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        repository.findAll();
        Optional<SystemUserDO> optional = repository.findByUsernameEquals(username);
        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }
        return optional.get();
    }
}
