package com.github.springbootsecurity.controller;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.pojo.UserRoleDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:13 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserRootController {

    ReturnDTO<List<UserInfoDO>> findAllUsers();

    ReturnDTO<List<UserRoleDO>> findAllRoles();

    ReturnDTO<List<UserBookDO>> findAllBooks();

}
