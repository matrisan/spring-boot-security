package com.github.springbootsecurity.controller.application;

import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 上午11:15 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IBookManagementController {

    /**
     * 获取所有的图书信息
     *
     * @param pageable pageable
     * @return Page
     */
    ReturnDTO<Page<UserBookDO>> findAllBooks(Pageable pageable);

    /**
     * 保存图书信息
     *
     * @param userBookDO UserBookDO
     * @return UserBookDO
     */
    ReturnDTO<UserBookDO> saveBook(UserBookDO userBookDO);

    /**
     * @param userBookDO
     * @return
     */
    ReturnDTO<UserBookDO> updateBook(UserBookDO userBookDO);

    /**
     * @param bookId
     * @return
     */
    ReturnDTO<Void> deleteBookById(long bookId);

}
