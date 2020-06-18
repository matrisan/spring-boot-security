package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.security.repository.IRoleRepository;
import com.github.springbootsecurity.security.service.IManagerRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * @author 石少东
 * @date 2020-06-18 14:14
 * @since 1.0
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerRoleServiceImpl implements IManagerRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public Page<SystemRoleVO> findAllRoles(Pageable pageable) {
        return null;
    }

    @Override
    public SystemRoleVO findByRoleById(SystemRoleDO role) {
        return null;
    }

    @Override
    public SystemRoleVO createRole(SystemRoleDTO user) {
        return null;
    }

    @Override
    public void deleteRoleById(SystemRoleDO user) {

    }
}
