package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.PayDTO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
import com.github.springbootsecurity.security.service.ISystemCenterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * <p>
 * 创建时间为 下午4:09 2020/3/3
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class SystemCenterServiceImpl implements ISystemCenterService {

    @Resource
    private ISystemRoleRepository roleRepository;

    @Resource
    private ISystemUserRepository userRepository;

    @Resource
    private ISystemGroupRepository groupRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public void pay(PayDTO pay, SystemUserDO authentication) {
        Optional<SystemRoleDO> optional = roleRepository.findByRoleNameEquals("ROLE_VIP");
        optional.ifPresent(
                systemRole -> {
                    groupRepository.save(authentication.getSystemGroup().addVipRole(systemRole));
                    userRepository.save(authentication.addVipRole(systemRole));
                }
        );
    }

}
