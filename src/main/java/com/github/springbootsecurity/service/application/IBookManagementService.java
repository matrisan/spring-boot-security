package com.github.springbootsecurity.service.application;

import com.github.springbootsecurity.pojo.doo.UserBookDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

public interface IBookManagementService {

    Page<UserBookDO> findAllBooks(Pageable pageable);

    UserBookDO saveBook(UserBookDO userBookDO);

    UserBookDO updateBook(UserBookDO userBookDO);

    void deleteBookById(long bookId);

}
