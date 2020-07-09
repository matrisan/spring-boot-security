package com.github.springbootsecurity.security.service.manager.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemRoleVO;
import com.github.springbootsecurity.security.repository.IRoleRepository;
import com.github.springbootsecurity.security.service.manager.IManagerRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * @author 石少东
 * @date 2020-06-18 14:14
 * @since 1.0
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ManagerRoleServiceImpl implements IManagerRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public Page<ISystemRoleVO> findAllRoles(Pageable pageable) {
        return roleRepository.findAllBy(pageable, ISystemRoleVO.class);
    }

    @Override
    public ISystemRoleVO findByRoleById(@NotNull SystemRoleDO role) {
        return roleRepository.findById(role.getId(), ISystemRoleVO.class);
    }

    @Override
    public ISystemRoleVO createRole(SystemRoleDTO user) {
        return null;
    }

    @Override
    public void deleteRoleById(SystemRoleDO user) {
         roleRepository.delete(user);
    }
}


