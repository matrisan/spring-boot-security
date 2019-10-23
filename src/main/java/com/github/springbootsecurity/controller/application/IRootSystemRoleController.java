package com.github.springbootsecurity.controller.application;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.pojo.vo.SystemRoleVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

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

public interface IRootSystemRoleController {

    ReturnDTO<Page<SystemRoleVO>> findAllRoles(Pageable pageable);

    ReturnDTO<SystemRoleVO> saveRole(@Valid SystemRoleDO systemRoleDO);

    ReturnDTO<SystemRoleVO> updateRole(@Valid SystemRoleDO systemRoleDO);

    ReturnDTO<Void> deleteRole(long roleId);

}
