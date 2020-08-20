package com.github.springbootsecurity.security.service.manager.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.vo.ISystemRoleVO;
import com.github.springbootsecurity.security.repository.IRoleRepository;
import com.github.springbootsecurity.security.service.manager.IManagerRoleService;
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
    public ISystemRoleVO findByRoleById(Long roleId) {
        return roleRepository.findById(roleId, ISystemRoleVO.class);
    }

    @Override
    public void createRole(SystemRoleDTO user) {

    }

    @Override
    public void deleteRoleById(Long roleId) {
         roleRepository.deleteById(roleId);
    }
}


