package com.github.springbootsecurity.controller.application;

import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.pojo.doo.UserBookDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 创建时间为 下午12:44 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserCenterController {

    /**
     * 只要登录用户才能访问
     * 获取本人的 Authentication
     *
     * @return Authentication
     */
    ReturnDTO<Authentication> getAuthentication();

    /**
     * 只要登录用户才能访问
     * 获取本人的 UserDetails
     *
     * @param systemUserDO UserDetails
     * @return UserDetails
     */
    ReturnDTO<SystemUserDO> getUserDetails(SystemUserDO systemUserDO);


//    ReturnDTO<SystemUserDO> changePassword();

    /**
     * @param pageable Pageable
     * @return Page
     */
    ReturnDTO<Page<UserBookDO>> findAllBooksOwned(Pageable pageable);

    /**
     * 只有 本人能获取本人的信息
     *
     * @param userBookDO 书名信息
     * @return UserBookDO
     */
    ReturnDTO<UserBookDO> findByBookId(@PathVariable("bookId") UserBookDO userBookDO);




}
