package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.doo.SystemUserDO;
import com.github.springbootsecurity.security.service.ISystemUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@PreAuthorize("hasRole('ROLE_ROOT')")
public class SystemUserController {

    @Resource
    private ISystemUserService service;

    @GetMapping("/")
    public String index() {
        return "Hello";
    }

    @GetMapping("/users")
    public Page<SystemUserDO> findAllUsers(@PageableDefault(size = 5, page = 0, sort = "userId", direction = Sort.Direction.ASC)
                                                   Pageable pageable) {
        return service.findAllUsers(pageable);
    }

}
