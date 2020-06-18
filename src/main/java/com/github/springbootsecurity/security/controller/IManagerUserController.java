package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 石少东
 * @date 2020-06-17 17:48
 * @since 1.0.0
 */

public interface IManagerUserController<T extends ISystemUserVO> {

    /**
     * 分页查找所有的用户
     *
     * @param pageable 分页信息
     * @return Page
     */
    ResultVO<Page<T>> findAllUsers(Pageable pageable);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名
     * @return ResultVO
     */
    ResultVO<T> findByUserByUsername(String username);

    /**
     * 创建用户
     *
     * @param user 用户信息
     * @return ResultVO
     */
    ResultVO<T> createUser(SystemUserDO user);

    /**
     * 根据用户的 ID 删除用户
     *
     * @param user 用户信息
     * @return ResultVO
     */
    ResultVO<Void> deleteUserById(SystemUserDO user);
}
