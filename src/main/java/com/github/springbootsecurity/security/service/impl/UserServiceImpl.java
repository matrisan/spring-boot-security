package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.mapper.DoMapper;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.security.repository.IUserRepository;
import com.github.springbootsecurity.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    private final IUserRepository userJpaRepository;

    @Override
    public Page<SystemUserVO> findUsers(Pageable pageable, SystemUserDO auth) {
        return userJpaRepository.findAllBy(pageable, SystemUserVO.class);
    }

    @Override
    public SystemUserVO findByUserByUsername(String username) {
        Optional<SystemUserVO> optional = userJpaRepository.findByUsernameEquals(username, SystemUserVO.class);
        return optional.orElse(null);
    }

    @Override
    public SystemUserVO createUser(SystemUserDTO user) {
        SystemUserDO save = DoMapper.mapper(user, SystemUserDO.class);
        userJpaRepository.save(save);
        return null;
    }

    @Override
    public void deleteUserById(SystemUserDO user) {

    }
}
