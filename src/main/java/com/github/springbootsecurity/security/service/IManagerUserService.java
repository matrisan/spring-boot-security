package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 上午12:20 2020/5/12
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface IManagerUserService {

    Page<ISystemUserVO> findAllUsers(Pageable pageable);

    ISystemUserVO findByUserByUsername(String username);

    SystemUserVO createUser(SystemUserDTO user);

    Void deleteUser(SystemUserDO user);
}
