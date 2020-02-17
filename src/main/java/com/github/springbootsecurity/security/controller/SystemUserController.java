package com.github.springbootsecurity.security.controller;

import com.github.springbootsecurity.security.pojo.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.SystemUserDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.github.springbootsecurity.security.repository.ISystemUserRepository;
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
import java.util.List;

/**
 * <p>
 * 创建时间为 下午8:01 2020/2/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/system/root")
public class SystemUserController {

    @Resource
    private ISystemUserRepository repository;

    @GetMapping("/user")
    public List<SystemUserDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/user/{id}")
    public SystemUserDO findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/user")
    public SystemUserDO save(@RequestBody SystemUserDO systemGroup) {
        return repository.save(systemGroup);
    }

    @PutMapping("/user")
    public SystemUserDO update(@RequestBody SystemUserDO systemGroup) {
        return repository.save(systemGroup);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
