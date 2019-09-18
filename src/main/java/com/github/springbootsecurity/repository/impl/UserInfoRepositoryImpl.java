package com.github.springbootsecurity.repository.impl;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.repository.IUserInfoRepository;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午7:12 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository
public class UserInfoRepositoryImpl implements IUserInfoRepository {

    @Resource(name = "userInfo")
    private ConcurrentHashMap<String, UserInfoDO> mapUser;

    @Resource(name = "userBook")
    private ConcurrentHashMap<String, UserBookDO> mapBook;

    @Override
    public List<UserBookDO> findBooksByUsername(String name) {
        return mapBook.values().stream()
                .filter(one -> StringUtils.equals(one.getUsername(), name))
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoDO findUserInfoByUsername(String username) {
        return mapUser.getOrDefault(username, null);
    }

    @Override
    public List<UserInfoDO> findAll() {
        return Lists.newArrayList(mapUser.values());
    }
}
