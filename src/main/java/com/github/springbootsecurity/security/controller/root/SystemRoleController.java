package com.github.springbootsecurity.security.controller.root;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
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
public class SystemRoleController {

    @Resource
    private ISystemRoleRepository repository;

    @GetMapping("/role")
    public List<SystemRoleDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/role/{id}")
    public SystemRoleDO findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/role")
    public SystemRoleDO save(@RequestBody SystemRoleDO systemGroup) {
        return repository.save(systemGroup);
    }

    @PutMapping("/role")
    public SystemRoleDO update(@RequestBody SystemRoleDO systemGroup) {
        return repository.save(systemGroup);
    }

    @DeleteMapping("/role/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
