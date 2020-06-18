package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.security.repository.IUserRepository;
import com.github.springbootsecurity.security.service.IManagerUserService;
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
@RequiredArgsConstructor
@Service
public class ManagerUserServiceImpl implements IManagerUserService {

    private final IUserRepository userJpaRepository;

    @Override
    public Page<ISystemUserVO> findAllUsers(Pageable pageable) {
        return userJpaRepository.findAllBy(pageable, ISystemUserVO.class);
    }

    @Override
    public ISystemUserVO findByUserByUsername(String username) {
        return userJpaRepository.findByUsernameIs(username, ISystemUserVO.class);
    }

    @Override
    public SystemUserVO createUser(SystemUserDTO user) {
        return null;
    }

    @Override
    public Void deleteUser(SystemUserDO user) {
        userJpaRepository.delete(user);
        return null;
    }

}
