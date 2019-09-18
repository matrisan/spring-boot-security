package com.github.springbootsecurity.repository.impl;

import com.github.springbootsecurity.pojo.UserRoleDO;
import com.github.springbootsecurity.repository.IUserRoleRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 创建时间为 下午7:14 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Repository
public class UserRoleRepositoryImpl implements IUserRoleRepository {

    @Resource(name = "userRole")
    private ConcurrentHashMap<String, UserRoleDO> map;

    @Override
    public List<UserRoleDO> findAll() {
        return Lists.newArrayList(map.values());
    }
}
