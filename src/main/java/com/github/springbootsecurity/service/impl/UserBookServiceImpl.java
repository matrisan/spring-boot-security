package com.github.springbootsecurity.service.impl;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.repository.IUserBookRepository;
import com.github.springbootsecurity.service.IUserBookService;
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
    private IUserBookRepository repository;

    @Override
    public UserBookDO findBookByBookName(String name) {
        return repository.findByBookName(name);
    }

    @Override
    public List<UserBookDO> findAllBooks() {
        return repository.findAll();
    }

}
