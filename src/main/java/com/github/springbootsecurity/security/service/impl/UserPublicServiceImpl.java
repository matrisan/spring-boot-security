package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.repository.IUserRepository;
import com.github.springbootsecurity.security.service.IUserPublicService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author 石少东
 * @date 2020-06-16 17:55
 */

@Service
@RequiredArgsConstructor
public class UserPublicServiceImpl implements IUserPublicService {

    private final IUserRepository repository;

    @Override
    public Void register(UserRegisterDTO register) {
        repository.save(getSystemUser(register));
        return null;
    }

    private @NotNull SystemUserDO getSystemUser(UserRegisterDTO register) {
        SystemUserDO user = new SystemUserDO();
        BeanUtils.copyProperties(register, user);
        return user;
    }
}
