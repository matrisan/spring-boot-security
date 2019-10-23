package com.github.springbootsecurity.service.security.impl;

import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.repository.IUserBookJpaRepository;
import com.github.springbootsecurity.service.security.IUserAuthorizeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午7:45 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserAuthorizeServiceImpl implements IUserAuthorizeService {

    @Resource
    private IUserBookJpaRepository repository;

    @Override
    public boolean hasPermission(@NotNull Authentication authentication, String bookName) {
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        Set<String> set = repository.findAllByUsernameEquals(username).stream().map(UserBookDO::getUsername).collect(Collectors.toSet());
        return set.contains(bookName);
    }

}
