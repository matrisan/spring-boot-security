package com.github.springbootsecurity.security.controller.impl;


import com.github.springbootsecurity.security.controller.IUserCenterController;
import com.github.springbootsecurity.security.pojo.dto.ResetPasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.service.common.IUserCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 石少东
 * @date 2020-06-16 17:07
 */


@RestController
@RequestMapping("/user/center")
@RequiredArgsConstructor
public class UserCenterControllerImpl implements IUserCenterController<ISystemUserVO, SystemUserDTO<Void>,Void> {

    private final IUserCenterService service;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    @Override
    public ResultVO<ISystemUserVO> me() {
        return ResultVO.success(service.me());
    }

    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping("/message")
    public ResultVO<ISystemUserVO> message() {
        return ResultVO.success(service.me());
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/info")
    @Override
    public ResultVO<Void> updateUserInfo(@RequestBody SystemUserDTO<Void> systemUser) {
        return ResultVO.success(service.updateUserInfo(systemUser));
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/password/reset")
    @Override
    public ResultVO<Void> resetPassword(@RequestBody @Validated ResetPasswordDTO resetPassword) {
        return ResultVO.success(service.resetPassword(resetPassword));
    }

}
