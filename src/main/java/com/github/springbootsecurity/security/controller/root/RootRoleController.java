package com.github.springbootsecurity.security.controller.root;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
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
public class RootRoleController {

    @Resource
    private ISystemRoleRepository repository;

    @GetMapping("/role")
    public ResultDTO<Page<SystemRoleDO>> findAll(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        return ResultDTO.success(repository.findAll(pageable));
    }

    @GetMapping("/role/{id}")
    public ResultDTO<SystemRoleDO> findById(@PathVariable Long id) {
        return ResultDTO.success(repository.findById(id).orElse(null));
    }

    @PostMapping("/role")
    public ResultDTO<SystemRoleDO> save(@RequestBody SystemRoleDO systemGroup) {
        return ResultDTO.success(repository.save(systemGroup));
    }

    @PutMapping("/role")
    public ResultDTO<SystemRoleDO> update(@RequestBody SystemRoleDO systemGroup) {
        return ResultDTO.success(repository.save(systemGroup));
    }

    @DeleteMapping("/role/{id}")
    public ResultDTO<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResultDTO.success();
    }

}
