package com.github.springbootsecurity.security.service.impl;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.CommonGroupVO;
import com.github.springbootsecurity.security.repository.ISystemGroupRepository;
import com.github.springbootsecurity.security.service.ICommonGroupService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Supplier;

/**
 * <p>
 * 创建时间为 下午3:40 2020/3/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class CommonGroupServiceImpl implements ICommonGroupService {

    @Resource
    private ISystemGroupRepository repository;

    @Override
    public SystemGroupDO findById(Long groupId) {
        return repository.findById(groupId).orElseGet(SystemGroupDO::new);
    }

    @Override
    public SystemGroupDO save(SystemGroupDO systemGroup, @NotNull SystemUserDO systemUser) {
        return saveOrUpdate(systemGroup, systemUser);
    }

    @Override
    public SystemGroupDO update(SystemGroupDO systemGroup, SystemUserDO systemUser) {
        return saveOrUpdate(systemGroup, systemUser);
    }

    @Override
    public void deleteById(Long groupId) {
        repository.deleteById(groupId);
    }

    private @NotNull SystemGroupDO saveOrUpdate(@NotNull SystemGroupDO commonGroup, @NotNull SystemUserDO systemUser) {
        commonGroup.setParentGroup(systemUser.getSystemGroup());
        return repository.save(commonGroup);
    }


}
