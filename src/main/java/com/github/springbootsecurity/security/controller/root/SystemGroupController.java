package com.github.springbootsecurity.security.controller.root;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
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
@PreAuthorize("hasRole('ROLE_ROOT')")
@RequestMapping("/system/root")
public class SystemGroupController {

    @Resource
    private ISystemGroupRepository repository;

    @GetMapping("/group")
    public List<SystemGroupDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/group/{id}")
    public SystemGroupDO findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/group")
    public SystemGroupDO save(@RequestBody SystemGroupDO systemGroup) {
        return repository.save(systemGroup);
    }

    @PutMapping("/group")
    public SystemGroupDO update(@RequestBody SystemGroupDO systemGroup) {
        return repository.save(systemGroup);
    }

    @DeleteMapping("/group/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
