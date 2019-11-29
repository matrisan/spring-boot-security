package com.github.springbootsecurity.security;


import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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

    @Resource
    private ISystemUserJpaRepository repository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    @SneakyThrows(UsernameNotFoundException.class)
    public UserDetails loadUserByUsername(String username) {
        SystemUserDO systemUserDO = repository.findByUsernameEquals(username);
        if (null == systemUserDO) {
            throw new UsernameNotFoundException(username);
        }
        return systemUserDO;
    }
}
