package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.repository.IUserBookJpaRepository;
import com.github.springbootsecurity.service.application.IBookManagementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 下午1:03 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class BookManagementServiceImpl implements IBookManagementService {

    @Resource
    private IUserBookJpaRepository bookJpaRepository;

    @Override
    public Page<UserBookDO> findAllBooks(Pageable pageable) {
        return bookJpaRepository.findAll(pageable);
    }

    @Override
    public UserBookDO saveBook(UserBookDO userBookDO) {
        return bookJpaRepository.save(userBookDO);
    }

    @Override
    public UserBookDO updateBook(UserBookDO userBookDO) {
        return bookJpaRepository.save(userBookDO);
    }

    @Override
    public void deleteBookById(long bookId) {
        bookJpaRepository.deleteById(bookId);
    }

}
