package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 石少东
 * @date 2020-06-17 17:48
 * @since
 */

public interface IUserManagerController<T extends ISystemUserVO> {

    ResultVO<Page<T>> findAllUsers(Pageable pageable);

    ResultVO<T> findByUserByUsername(@PathVariable String username);

    ResultVO<T> createUser(SystemUserDO user);

    ResultVO<Void> deleteUserById(@PathVariable("id") SystemUserDO user);
}
