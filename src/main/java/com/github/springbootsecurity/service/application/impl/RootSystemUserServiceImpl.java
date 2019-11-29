package com.github.springbootsecurity.service.application.impl;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.repository.ISystemRoleJpaRepository;
import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
import com.github.springbootsecurity.service.application.IRootSystemUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 上午11:45 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Service
public class RootSystemUserServiceImpl implements IRootSystemUserService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private ISystemUserJpaRepository userJpaRepository;

    @Resource
    private ISystemRoleJpaRepository roleJpaRepository;

    @Override
    public Page<SystemUserVO> findAllUsers(Pageable pageable) {
        Page<SystemUserDO> pageDo = userJpaRepository.findAll(pageable);
        List<SystemUserVO> list = pageDo.getContent().stream().map(one -> {
            SystemUserVO userVO = new SystemUserVO();
            BeanUtils.copyProperties(one, userVO);
            userVO.setRoles(one.getAuthorities().stream().map(SystemRoleDO::getName).collect(Collectors.toSet()));
            return userVO;
        }).collect(Collectors.toList());
        return new PageImpl<>(list, pageDo.getPageable(), pageDo.getTotalElements());
    }

    @Override
    public SystemUserVO saveUser(SystemUserDTO systemUserDTO) {
        SystemUserDO systemUserDO = new SystemUserDO();
        BeanUtils.copyProperties(systemUserDTO, systemUserDO);
        systemUserDO.setPassword(passwordEncoder.encode(systemUserDTO.getPassword()));
        Set<SystemRoleDO> doSet = roleJpaRepository.findAllById(systemUserDTO.getRoles())
                .stream().peek(one -> one.setUsers(null)).collect(Collectors.toSet());
        systemUserDO.setAuthorities(doSet);
        SystemUserDO userDO = userJpaRepository.save(systemUserDO);
        SystemUserVO userVO = new SystemUserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return userVO;
    }

    @Override
    public SystemUserVO updateUser(SystemUserDTO systemUserDTO) {
        return saveUser(systemUserDTO);
    }

    @Override
    public void deleteUser(long roleId) {
        userJpaRepository.deleteById(roleId);
    }

}
