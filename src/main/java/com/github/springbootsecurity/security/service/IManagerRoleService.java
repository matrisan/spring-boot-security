package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
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

public interface IManagerRoleService {

    Page<SystemRoleVO> findAllRoles(Pageable pageable);

    SystemRoleVO findByRoleById(SystemRoleDO role);

    SystemRoleVO createRole(SystemRoleDTO user);

    void deleteRoleById(SystemRoleDO user);

}
