package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.controller.IManagerRoleController;
import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.security.service.IManagerRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-06-17 17:53
 * @since 1
 */


@RestController
@PreAuthorize("hasRole('ROLE_ROOT')")
@RequestMapping("/manager/role")
@RequiredArgsConstructor
public class ManagerRoleControllerImpl implements IManagerRoleController<SystemRoleDTO> {

    private final IManagerRoleService service;

    @GetMapping("roles")
    @Override
    public ResultVO<Page<SystemRoleVO>> findAllRoles(Pageable pageable) {
        return ResultVO.success(service.findAllRoles(pageable));
    }

    @GetMapping("role/{id}")
    @Override
    public ResultVO<SystemRoleVO> findByRoleById(@PathVariable("id") SystemRoleDO role) {
        return null;
    }

    @PostMapping("role")
    @Override
    public ResultVO<SystemRoleVO> createRole(SystemRoleDTO role) {
        return null;
    }

    @DeleteMapping("role/{id}")
    @Override
    public ResultVO<Void> deleteRoleById(@PathVariable("id") SystemRoleDO role) {
        return null;
    }
}
