package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemRoleDTO;
import com.github.springbootsecurity.security.pojo.mapper.DoMapper;
import com.github.springbootsecurity.security.pojo.mapper.VoMapper;
import com.github.springbootsecurity.security.pojo.orm.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.security.repository.ISystemRoleJpaRepository;
import com.github.springbootsecurity.security.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 上午9:12 2020/5/12
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final ISystemRoleJpaRepository roleJpaRepository;

    @Override
    public Page<SystemRoleVO> findAllRoles(Pageable pageable, SystemUserDO auth) {
        return roleJpaRepository.findAll(pageable).map(SystemRoleVO::mapper);
    }

    @Override
    public SystemRoleVO findByRoleById(SystemRoleDO role) {
        return SystemRoleVO.mapper(role);
    }

    @Override
    public SystemRoleVO createRole(SystemRoleDTO role) {
        SystemRoleDO toSave = DoMapper.mapper(role, SystemRoleDO.class);
        SystemRoleDO value = roleJpaRepository.save(toSave);
        return SystemRoleVO.mapper(value);
    }

    @Override
    public void deleteRoleById(SystemRoleDO role) {
        roleJpaRepository.delete(role);
    }
}
