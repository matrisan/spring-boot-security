package com.github.springbootsecurity.service.impl;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.repository.IUserInfoRepository;
import com.github.springbootsecurity.service.IUserAuthorizeService;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
    private IUserInfoRepository repository;

    @Override
    public boolean hasPermission(@NotNull Authentication authentication, String bookName) {
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        List<UserBookDO> list = repository.findBooksByUsername(username);
        Set<String> set = list.stream().map(UserBookDO::getName).collect(Collectors.toSet());
        return set.contains(bookName);
    }

}
