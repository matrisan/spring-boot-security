package com.github.springbootsecurity.controller.impl;

import com.github.springbootsecurity.controller.IUserRootController;
import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.pojo.UserRoleDO;
import com.github.springbootsecurity.pojo.dto.ReturnDTO;
import com.github.springbootsecurity.service.IUserRootService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 创建时间为 下午3:15 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Slf4j
@RequestMapping("/root")
@RestController
public class UserRootControllerImpl implements IUserRootController {

    @Resource
    private IUserRootService service;

    @GetMapping("/users")
    @Override
    public ReturnDTO<List<UserInfoDO>> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/roles")
    @Override
    public ReturnDTO<List<UserRoleDO>> findAllRoles() {
        return service.findAllRoles();
    }

    @GetMapping("/books")
    @Override
    public ReturnDTO<List<UserBookDO>> findAllBooks() {
        return service.findAllBooks();
    }
}
