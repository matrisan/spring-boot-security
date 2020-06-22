package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.controller.IManagerUserController;
import com.github.springbootsecurity.security.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.service.IManagerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 石少东
 * @date 2020-06-16 15:53
 */

@RestController
@PreAuthorize("hasRole('ROLE_ROOT')")
@RequestMapping("/manager/user")
@RequiredArgsConstructor
public class ManagerUserControllerImpl implements IManagerUserController<ISystemUserVO,Void> {

    private final IManagerUserService service;

    @GetMapping("/users")
    @Override
    public ResultVO<Page<ISystemUserVO>> findAllUsers(Pageable pageable) {
        return ResultVO.success(service.findAllUsers(pageable));
    }

    @GetMapping("/user/{username}")
    @Override
    public ResultVO<ISystemUserVO> findByUserByUsername(@PathVariable String username) {
        return ResultVO.success(service.findByUserByUsername(username));
    }

    @PostMapping("/user")
    @Override
    public ResultVO<ISystemUserVO> createUser(@RequestBody SystemUserDTO<Void> user) {
        return null;
    }

    @DeleteMapping("/user/{id}")
    @Override
    public ResultVO<Void> deleteUserById(@PathVariable("id") SystemUserDO user) {
        return ResultVO.success(service.deleteUser(user));
    }

}
