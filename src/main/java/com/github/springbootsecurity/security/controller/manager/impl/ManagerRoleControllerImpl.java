package com.github.springbootsecurity.security.controller.manager.impl;

import com.github.springbootsecurity.security.controller.manager.IManagerRoleController;
import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.vo.ISystemRoleVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.service.manager.IManagerRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public ResultVO<Page<ISystemRoleVO>> findAllRoles(@PageableDefault(direction = Sort.Direction.DESC, sort = "createDate") Pageable pageable) {
        return ResultVO.success(service.findAllRoles(pageable));
    }

    @GetMapping("role/{id}")
    @Override
    public ResultVO<ISystemRoleVO> findByRoleById(@PathVariable("id") Long roleId) {
        return ResultVO.success(service.findByRoleById(roleId));
    }

    @PostMapping("role")
    @Override
    public ResultVO<Void> createRole(SystemRoleDTO role) {
        service.createRole(role);
        return ResultVO.success();
    }

    @DeleteMapping("role/{id}")
    @Override
    public ResultVO<Void> deleteRoleById(@PathVariable("id")  Long roleId) {
        service.deleteRoleById(roleId);
        return ResultVO.success();
    }
}
