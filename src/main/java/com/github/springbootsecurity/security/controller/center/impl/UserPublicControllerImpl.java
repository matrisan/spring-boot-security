package com.github.springbootsecurity.security.controller.center.impl;

import com.github.springbootsecurity.security.constraint.RetrieveType;
import com.github.springbootsecurity.security.controller.center.IUserPublicController;
import com.github.springbootsecurity.security.pojo.dto.RetrievePasswordDTO;
import com.github.springbootsecurity.security.pojo.dto.UserRegisterDTO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.RetrieveMessageVO;
import com.github.springbootsecurity.security.service.common.IUserPublicService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-06-16 17:09
 */


@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/public")
@RequiredArgsConstructor
public class UserPublicControllerImpl implements IUserPublicController<UserRegisterDTO> {

    private final IUserPublicService service;

    @GetMapping("index")
    public ResultVO<String> index() {
        return ResultVO.success("index");
    }

    @PostMapping("/register")
    @Override
    public ResultVO<Void> register(@RequestBody @Validated UserRegisterDTO register) {
        return ResultVO.success(service.register(register));
    }

    @PostMapping("/password/retrieve/{type}")
    @Override
    public ResultVO<RetrieveMessageVO> retrievePassword(@PathVariable @RetrieveType String type, @RequestBody RetrievePasswordDTO retrieve) {
        return ResultVO.success(service.retrievePassword(type, retrieve));
    }
}

