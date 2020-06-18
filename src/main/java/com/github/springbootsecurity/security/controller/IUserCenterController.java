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

    /**
     * 获取当前用户信息
     *
     * @return ResultVO
     */
    ResultVO<V> me();

    /**
     * 更新用户信息
     *
     * @param systemUser 用户信息
     * @return Void
     */
    ResultVO<Void> updateUserInfo(@RequestBody E systemUser);

    /**
     * 重置密码
     *
     * @param resetPassword 重置密码
     * @return Void
     */
    ResultVO<Void> resetPassword(@RequestBody @Validated ResetPasswordDTO resetPassword);

}
