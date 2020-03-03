package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 创建时间为 下午4:48 2020/3/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICommonRoleService {

    /**
     * @param pageable
     * @param authentication
     * @return
     */
    Page<SystemRoleDO> findAll(Pageable pageable, SystemUserDO authentication);

    /**
     * @param roleId
     * @return
     */
    SystemRoleDO findById(Long roleId);

    /**
     * @param systemRole
     * @param authentication
     * @return
     */
    SystemRoleDO save(SystemRoleDO systemRole, SystemUserDO authentication);

    /**
     * @param systemRole
     * @param authentication
     * @return
     */
    SystemRoleDO update(SystemRoleDO systemRole, SystemUserDO authentication);

    /**
     * @param roleId
     */
    void deleteById(Long roleId);
}
