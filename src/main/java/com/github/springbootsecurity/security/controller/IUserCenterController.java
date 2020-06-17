package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.dto.ResetPasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 石少东
 * @date 2020-06-16 17:07
 */

public interface IUserCenterController<V extends ISystemUserVO, E extends SystemUserDTO> {

    ResultVO<V> me();

    ResultVO<Void> updateUserInfo(@RequestBody E systemUser);

    ResultVO<Void> resetPassword(@RequestBody @Validated ResetPasswordDTO resetPassword);

}
