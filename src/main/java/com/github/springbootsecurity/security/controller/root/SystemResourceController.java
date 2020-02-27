package com.github.springbootsecurity.security.controller.root;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
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
public class SystemResourceController {

    @Resource
    private ISystemResourceRepository repository;

    @GetMapping("/resource")
    public List<SystemResourceDO> findAll() {
        return repository.findAll();
    }

    @GetMapping("/resource/{id}")
    public SystemResourceDO findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/resource")
    public SystemResourceDO save(@RequestBody SystemResourceDO systemGroup) {
        return repository.save(systemGroup);
    }

    @PutMapping("/resource")
    public SystemResourceDO update(@RequestBody SystemResourceDO systemGroup) {
        return repository.save(systemGroup);
    }

    @DeleteMapping("/resource/{id}")
    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
