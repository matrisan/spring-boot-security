package com.github.springbootsecurity.service.impl;

import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.repository.IUserInfoRepository;
import lombok.SneakyThrows;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

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
    private IUserInfoRepository repository;

    @SneakyThrows(UsernameNotFoundException.class)
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserInfoDO userInfoDO = repository.findUserInfoByUsername(username);
        if (null == userInfoDO) {
            throw new UsernameNotFoundException(username);
        }
        Collection<GrantedAuthority> collection = userInfoDO.getAuthorities();
        Set<String> roleSet = collection.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
        String password = userInfoDO.getPassword();
        String[] roles = new String[roleSet.size()];
        roleSet.toArray(roles);
        return new User(username, password, AuthorityUtils.createAuthorityList(roles));
    }
}
