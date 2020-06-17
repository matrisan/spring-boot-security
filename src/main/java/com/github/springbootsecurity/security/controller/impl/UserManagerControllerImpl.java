package com.github.springbootsecurity.security.controller.impl;

import com.github.springbootsecurity.security.pojo.orm.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.ISystemUserVO;
import com.github.springbootsecurity.security.pojo.vo.ResultVO;
import com.github.springbootsecurity.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 石少东
 * @date 2020-06-16 15:53
 */

@RestController
@RequiredArgsConstructor
public class UserManagerControllerImpl {

    private final IUserRepository repository;

    @GetMapping("/users")
    @PreAuthorize("isAuthenticated()")
    public ResultVO<Page<ISystemUserVO>> findAllUsers(Pageable pageable) {
        return ResultVO.success(repository.findAllBy(pageable, ISystemUserVO.class));
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("isAuthenticated()")
    public ResultVO<ISystemUserVO> findByUserByUsername(@PathVariable String username) {
        return ResultVO.success(repository.findByUsernameIs(username, ISystemUserVO.class));
    }

    @PostMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public ResultVO<ISystemUserVO> createUser(SystemUserDO user) {
        return null;
    }

    @DeleteMapping("/user/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResultVO<Void> deleteUserById(@PathVariable("id") SystemUserDO user) {
        repository.delete(user);
        return ResultVO.success();
    }

}
