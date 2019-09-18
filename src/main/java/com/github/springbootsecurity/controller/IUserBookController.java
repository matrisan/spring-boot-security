package com.github.springbootsecurity.controller;

import com.github.springbootsecurity.pojo.UserBookDO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

public interface IUserBookController {

    /**
     * 只有 本人能获取本人的信息
     *
     * @param bookName 书名
     * @return UserBookDO
     */
    UserBookDO getBookByBookName(@PathVariable String bookName);

    /**
     * 只有root 用户能获取所有的信息
     *
     * @return List
     */
    List<UserBookDO> getAllBooks();

}
