package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.dto.ResetPasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;

/**
 * @author 石少东
 * @date 2020-06-16 17:19
 */

public interface IUserCenterService {

    ISystemUserVO me();

    Void resetPassword(ResetPasswordDTO resetPassword);

    Void updateUserInfo(SystemUserDTO systemUser);
}
