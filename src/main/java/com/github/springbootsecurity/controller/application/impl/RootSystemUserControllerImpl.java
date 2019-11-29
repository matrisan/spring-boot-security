package com.github.springbootsecurity.controller.application.impl;

import com.github.springbootsecurity.controller.application.IRootSystemUserController;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.pojo.dto.SystemUserDTO;
import com.github.springbootsecurity.pojo.vo.SystemUserVO;
import com.github.springbootsecurity.service.application.IRootSystemUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 创建时间为 上午11:19 2019/10/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@RequestMapping("/root/center")
@PreAuthorize("hasRole('ROLE_ROOT')")
public class RootSystemUserControllerImpl implements IRootSystemUserController {

    @Resource
    private IRootSystemUserService service;

    @Override
    @GetMapping("/users")
    public ReturnDTO<Page<SystemUserVO>> findAllUsers(@PageableDefault(size = 5, page = 0, sort = "userId", direction = Sort.Direction.ASC)
                                                              Pageable pageable) {
        return ReturnDTO.<Page<SystemUserVO>>builder().status(0).data(service.findAllUsers(pageable)).build();
    }

    @Override
    @PostMapping("/user")
    public ReturnDTO<SystemUserVO> saveUser(@Valid @RequestBody SystemUserDTO systemUserDTO) {
        return ReturnDTO.<SystemUserVO>builder().status(0).data(service.saveUser(systemUserDTO)).build();
    }

    @Override
    @PutMapping("/user")
    public ReturnDTO<SystemUserVO> updateUser(@Valid @RequestBody SystemUserDTO systemUserDTO) {
        return ReturnDTO.<SystemUserVO>builder().status(0).data(service.updateUser(systemUserDTO)).build();
    }

    @Override
    @DeleteMapping("/user/{userId}")
    public ReturnDTO<Void> deleteUser(@PathVariable long userId) {
        service.deleteUser(userId);
        return ReturnDTO.<Void>builder().status(0).build();
    }

}
