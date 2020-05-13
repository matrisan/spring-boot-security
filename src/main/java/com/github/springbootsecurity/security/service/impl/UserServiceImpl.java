package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.mapper.DoMapper;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.security.repository.ISystemUserJpaRepository;
import com.github.springbootsecurity.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 上午12:21 2020/5/12
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final ISystemUserJpaRepository userJpaRepository;

    @Override
    public Page<SystemUserVO> findAllUsers(Pageable pageable, SystemUserDO auth) {
        return userJpaRepository.findAll(pageable).map(SystemUserVO::mapper);
    }

    @Override
    public SystemUserVO findByUserById(SystemUserDO user) {
        return SystemUserVO.mapper(user);
    }

    @Override
    public SystemUserVO createUser(SystemUserDTO user) {
        SystemUserDO save = DoMapper.mapper(user, SystemUserDO.class);
        SystemUserDO result = userJpaRepository.save(save);
        return SystemUserVO.mapper(result);
    }

    @Override
    public void deleteUserById(SystemUserDO user) {

    }
}
