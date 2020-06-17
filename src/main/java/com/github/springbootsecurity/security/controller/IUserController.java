package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * <p>
 * 创建时间为 下午3:37 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserController<V, U> {

    /**
     * 获取用户信息
     *
     * @param auth 用户信息
     * @return 用户信息
     */
    @PreAuthorize("isAuthenticated()")
    ResultVO<V> me(U auth);

    /**
     * 获取所有的用户
     *
     * @param pageable 分页信息
     * @param auth     当前用户信息
     * @return Page
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<Page<V>> findAllUsers(Pageable pageable, U auth);

    /**
     * 根据用户的ID查找用户
     *
     * @param username 用户信息
     * @return SystemUserVO
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<V> findByUserByUsername(String username);

    /**
     * 创建新用户
     *
     * @param user 用户信息
     * @return SystemUserVO
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<V> createUser(U user);

    /**
     * 根据ID删除用户
     *
     * @param user 用户信息
     * @return Void
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<V> deleteUserById(U user);

}
