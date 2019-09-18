package com.github.springbootsecurity.repository;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.pojo.UserInfoDO;

import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:03 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IUserInfoRepository {

    List<UserBookDO> findBooksByUsername(String username);

    UserInfoDO findUserInfoByUsername(String username);

    List<UserInfoDO> findAll();
}
