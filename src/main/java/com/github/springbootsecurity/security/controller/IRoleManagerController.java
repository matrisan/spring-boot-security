package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author 石少东
 * @date 2020-06-17 17:53
 * @since 1.0
 */


public interface IRoleManagerController<T extends SystemRoleDTO> {

    /**
     * 查找所有的角色
     *
     * @param pageable 分页信息
     * @return Page
     */
    ResultVO<Page<SystemRoleVO>> findAllRoles(Pageable pageable);

    /**
     * 根据ID查找角色
     *
     * @param role 角色信息
     * @return SystemRoleVO
     */
    ResultVO<SystemRoleVO> findByRoleById(SystemRoleDO role);

    /**
     * 创建新用户
     *
     * @param role 用户信息
     * @return SystemRoleVO
     */
    ResultVO<SystemRoleVO> createRole(T role);

    /**
     * 根据ID删除用户
     *
     * @param role 用户信息
     * @return Void
     */
    ResultVO<Void> deleteRoleById(SystemRoleDO role);


}
