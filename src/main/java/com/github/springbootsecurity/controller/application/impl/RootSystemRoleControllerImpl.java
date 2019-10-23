package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.IRootSystemRoleController;
import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.service.application.IRootSystemRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 创建时间为 上午11:05 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@RequestMapping("/root/center")
@PreAuthorize("hasRole('ROLE_ROOT')")
public class RootSystemRoleControllerImpl implements IRootSystemRoleController {

    @Resource
    private IRootSystemRoleService service;

    @Override
    @GetMapping("/roles")
    public ReturnDTO<Page<SystemRoleVO>> findAllRoles(@PageableDefault(size = 5, page = 0, sort = "roleId", direction = Sort.Direction.ASC)
                                                              Pageable pageable) {
        return ReturnDTO.<Page<SystemRoleVO>>builder().status(0).data(service.findAllRoles(pageable)).build();
    }

    @Override
    @PostMapping("/role")
    public ReturnDTO<SystemRoleVO> saveRole(@Valid @RequestBody SystemRoleDO systemRoleDO) {
        return ReturnDTO.<SystemRoleVO>builder().status(0).data(service.saveRole(systemRoleDO)).build();
    }

    @Override
    @PutMapping("/role")
    public ReturnDTO<SystemRoleVO> updateRole(@Valid @RequestBody SystemRoleDO systemRoleDO) {
        return ReturnDTO.<SystemRoleVO>builder().status(0).data(service.updateRole(systemRoleDO)).build();
    }

    @Override
    @DeleteMapping("/role/{roleId}")
    public ReturnDTO<Void> deleteRole(@PathVariable long roleId) {
        service.deleteRole(roleId);
        return ReturnDTO.<Void>builder().status(0).build();
    }
}
