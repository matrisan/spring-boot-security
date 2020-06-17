package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.controller.IRoleManagerController;
import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.security.service.IRoleManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-06-17 17:53
 * @since 1
 */


@RestController
@PreAuthorize("hasRole('ROLE_ROOT')")
@RequiredArgsConstructor
public class RoleManagerControllerImpl implements IRoleManagerController<SystemRoleDTO> {

    private final IRoleManagerService service;

    @Override
    public ResultVO<Page<SystemRoleVO>> findAllRoles(Pageable pageable) {
        return ResultVO.success(service.findAllRoles(pageable));
    }

    @Override
    public ResultVO<SystemRoleVO> findByRoleById(SystemRoleDO role) {
        return null;
    }

    @Override
    public ResultVO<SystemRoleVO> createRole(SystemRoleDTO role) {
        return null;
    }

    @Override
    public ResultVO<Void> deleteRoleById(SystemRoleDO role) {
        return null;
    }
}
