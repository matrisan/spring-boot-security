package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.service.IUserPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-06-16 17:09
 */


@RestController
@RequiredArgsConstructor
public class UserPublicControllerImpl {

    private final IUserPublicService service;

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public ResultVO<Void> register(@RequestBody @Validated UserRegisterDTO register) {
        return ResultVO.success(service.register(register));
    }


}
