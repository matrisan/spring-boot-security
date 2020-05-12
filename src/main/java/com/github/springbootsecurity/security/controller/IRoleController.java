package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
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

public interface IRoleController {

    /**
     * 查找所有的角色
     *
     * @param pageable 分页信息
     * @param auth     当前登录的用户信息
     * @return Page
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<Page<SystemRoleVO>> findAllRoles(Pageable pageable, SystemUserDO auth);

    /**
     * 根据ID查找角色
     *
     * @param role 角色信息
     * @return SystemRoleVO
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<SystemRoleVO> findByRoleById(SystemRoleDO role);

    /**
     * 创建新用户
     *
     * @param role 用户信息
     * @return SystemRoleVO
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<SystemRoleVO> createRole(SystemRoleDTO role);

    /**
     * 根据ID删除用户
     *
     * @param role 用户信息
     * @return Void
     */
    @PreAuthorize("hasRole('ROLE_ROOT')")
    ResultVO<Void> deleteRoleById(SystemRoleDO role);

}
