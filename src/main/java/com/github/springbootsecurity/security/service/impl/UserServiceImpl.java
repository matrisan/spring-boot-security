package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.mapper.SystemUserMapper;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.security.repository.IUserRepository;
import com.github.springbootsecurity.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userJpaRepository;

    @Override
    public SystemUserDO findById(long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public Page<SystemUserVO> findUsers(Pageable pageable, SystemUserDO auth) {
        return userJpaRepository.findAllBy(pageable, SystemUserVO.class);
    }

    @Override
    public SystemUserVO findByUserByUsername(String username) {
        return userJpaRepository.findByUsernameIs(username, SystemUserVO.class);
    }

    @Override
    public SystemUserVO createUser(SystemUserDTO user) {
        userJpaRepository.save(SystemUserMapper.mapper(user));
        return userJpaRepository.findByUsernameIs(user.getUsername(), SystemUserVO.class);
    }

    @Override
    public void deleteUserById(SystemUserDO user) {
        userJpaRepository.delete(user);
    }
}
