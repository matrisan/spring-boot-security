package com.github.springbootsecurity.security.service.manager;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemRoleVO;
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

    Page<ISystemRoleVO> findAllRoles(Pageable pageable);

    ISystemRoleVO findByRoleById(SystemRoleDO role);

    ISystemRoleVO createRole(SystemRoleDTO user);

    void deleteRoleById(SystemRoleDO user);

}
