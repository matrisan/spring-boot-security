package com.github.springbootsecurity.repository.impl;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.repository.IUserBookRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 创建时间为 下午7:13 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Repository("book")
public class UserBookRepositoryImpl implements IUserBookRepository {

    @Resource(name = "userBook")
    private ConcurrentHashMap<String, UserBookDO> map;

    @Override
    public UserBookDO findByBookName(String name) {
        return map.getOrDefault(name, null);
    }

    @Override
    public List<UserBookDO> findAll() {
        return Lists.newArrayList(map.values());
    }

    @Override
    public UserBookDO save(UserBookDO userBookDO) {
        return map.put(userBookDO.getName(), userBookDO);
    }

}
