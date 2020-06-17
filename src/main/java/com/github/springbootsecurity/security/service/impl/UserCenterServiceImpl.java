package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.dto.ResetPasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.repository.IUserRepository;
import com.github.springbootsecurity.security.service.IUserCenterService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

/**
 * @author 石少东
 * @date 2020-06-16 17:34
 */

@Service
@RequiredArgsConstructor
public class UserCenterServiceImpl  implements IUserCenterService {

    private final IUserRepository repository;

    @Override
    public ISystemUserVO me() {
        return repository.findCurrentUser(ISystemUserVO.class);
    }

    @Override
    public Void resetPassword(@NotNull ResetPasswordDTO resetPassword) {
        repository.updateCurrentPassword(resetPassword.getPasswordNew1());
        return null;
    }

    @Override
    public Void updateUserInfo(SystemUserDTO systemUser) {
        return null;
    }
}
