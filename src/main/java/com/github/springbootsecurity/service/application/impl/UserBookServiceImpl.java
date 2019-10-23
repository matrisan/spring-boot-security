package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.repository.IUserBookJpaRepository;
import com.github.springbootsecurity.service.application.IUserBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:10 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class UserBookServiceImpl implements IUserBookService {

    @Resource
    private IUserBookJpaRepository repository;

    @Override
    public List<UserBookDO> findAllBooks() {
        return repository.findAll();
    }

}
