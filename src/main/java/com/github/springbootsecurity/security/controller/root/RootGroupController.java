package com.github.springbootsecurity.security.controller.root;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
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
public class RootGroupController {

    @Resource
    private ISystemGroupRepository repository;

    @GetMapping("/group")
    public ResultDTO<Page<SystemGroupDO>> findAll(@PageableDefault(direction = Sort.Direction.DESC) Pageable pageable) {
        return ResultDTO.success("查询成功", repository.findAll(pageable));
    }

    @GetMapping("/group/{id}")
    public ResultDTO<SystemGroupDO> findById(@PathVariable Long id) {
        return ResultDTO.success("查询成功", repository.findById(id).orElse(null));
    }

    @PostMapping("/group")
    public ResultDTO<SystemGroupDO> save(@RequestBody SystemGroupDO systemGroup) {
        return ResultDTO.success("保存成功", repository.save(systemGroup));
    }

    @PutMapping("/group")
    public ResultDTO<SystemGroupDO> update(@RequestBody SystemGroupDO systemGroup) {
        return ResultDTO.success("查询成功", repository.save(systemGroup));
    }

    @DeleteMapping("/group/{id}")
    public ResultDTO<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResultDTO.success("删除成功");
    }

}
