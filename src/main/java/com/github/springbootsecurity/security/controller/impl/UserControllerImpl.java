package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.controller.IUserController;
import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 下午1:26 2020/5/11
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements IUserController<SystemUserVO> {

    private final IUserService service;

    @GetMapping("/me")
    @Override
    public ResultVO<SystemUserDO> me(@AuthenticationPrincipal(expression = "@userServiceImpl.findById(#this.id)") SystemUserDO auth) {
        return ResultVO.success(auth);
    }

    @GetMapping("/users")
    @Override
    public ResultVO<Page<SystemUserVO>> findAllUsers(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                                     @AuthenticationPrincipal SystemUserDO auth) {
        return ResultVO.success(service.findUsers(pageable, auth));
    }

    @GetMapping("/user/{username}")
    @Override
    public ResultVO<SystemUserVO> findByUserByUsername(@PathVariable String username) {
        return ResultVO.success(service.findByUserByUsername(username));
    }

    @PostMapping("/user")
    @Override
    public ResultVO<SystemUserVO> createUser(@RequestBody SystemUserDTO user) {
        return ResultVO.success(service.createUser(user));
    }

    @DeleteMapping("/user/{id}")
    @Override
    public ResultVO<Void> deleteUserById(@PathVariable("id") SystemUserDO user) {
        service.deleteUserById(user);
        return ResultVO.success();
    }
}
