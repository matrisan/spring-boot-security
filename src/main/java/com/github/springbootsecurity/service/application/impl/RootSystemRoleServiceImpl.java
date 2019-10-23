package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.repository.ISystemRoleJpaRepository;
import com.github.springbootsecurity.service.application.IRootSystemRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 上午11:07 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class RootSystemRoleServiceImpl implements IRootSystemRoleService {

    @Resource
    private ISystemRoleJpaRepository roleJpaRepository;

    @Override
    public Page<SystemRoleVO> findAllRoles(Pageable pageable) {
        Page<SystemRoleDO> doPage = roleJpaRepository.findAll(pageable);
        List<SystemRoleVO> voList = doPage.get().map(one -> {
            SystemRoleVO systemRoleVO = new SystemRoleVO();
            BeanUtils.copyProperties(one, systemRoleVO);
            return systemRoleVO;
        }).collect(Collectors.toList());
        return new PageImpl<>(voList, doPage.getPageable(), doPage.getTotalElements());
    }

    @Override
    public SystemRoleVO saveRole(SystemRoleDO systemRoleDO) {
        SystemRoleDO roleDO = roleJpaRepository.save(systemRoleDO);
        SystemRoleVO roleVO = new SystemRoleVO();
        BeanUtils.copyProperties(roleDO, roleVO);
        return roleVO;
    }

    @Override
    public SystemRoleVO updateRole(SystemRoleDO systemRoleDO) {
        return saveRole(systemRoleDO);
    }

    @Override
    public void deleteRole(long roleId) {
        roleJpaRepository.deleteById(roleId);
    }
}
