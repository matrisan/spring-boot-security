package com.github.springbootsecurity.security.service.common;

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
     * 查找当前组下面所有的
     *
     * @param pageable       分页信息
     * @param authentication 用户信息
     * @return Page
     */
    Page<SystemRoleDO> findAll(Pageable pageable, SystemUserDO authentication);

    /**
     * 根据 ID 查找所有的角色信息
     *
     * @param roleId roleId
     * @return SystemRoleDO
     */
    SystemRoleDO findById(Long roleId);

    /**
     * 保存一个角色信息
     *
     * @param systemRole     角色信息
     * @param authentication 用户信息
     * @return SystemRoleDO
     */
    SystemRoleDO save(SystemRoleDO systemRole, SystemUserDO authentication);

    /**
     * 更新一个角色信息
     *
     * @param systemRole     角色信息
     * @param authentication 用户信息
     * @return SystemRoleDO
     */
    SystemRoleDO update(SystemRoleDO systemRole, SystemUserDO authentication);

    /**
     * 删除一个角色
     *
     * @param roleId 角色ID
     */
    void deleteById(Long roleId);
}
