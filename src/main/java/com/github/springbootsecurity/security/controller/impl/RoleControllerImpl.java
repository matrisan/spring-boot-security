package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.controller.IRoleController;
import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.mapper.DoMapper;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.security.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午1:25 2020/5/11
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements IRoleController {

    private final IRoleService roleService;

    @Override
    public ResultVO<Page<SystemRoleVO>> findAllRoles(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable, @AuthenticationPrincipal SystemUserDO auth) {
        return ResultVO.success(roleService.findAllRoles(pageable, auth));
    }

    @Override
    public ResultVO<SystemRoleVO> findByRoleById(@PathVariable SystemRoleDO role) {
        return ResultVO.success(roleService.findByRoleById(role));
    }

    @Override
    public ResultVO<SystemRoleVO> createRole(@RequestBody SystemRoleDTO role) {
        return ResultVO.success(roleService.createRole(role));
    }

    @Override
    public ResultVO<Void> deleteRoleById(@PathVariable SystemRoleDO role) {
        roleService.deleteRoleById(role);
        return ResultVO.success();
    }

}
