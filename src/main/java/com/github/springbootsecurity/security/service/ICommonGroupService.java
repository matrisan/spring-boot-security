package com.github.springbootsecurity.security.service;

import com.github.springbootsecurity.security.pojo.dto.CommonGroupDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.pojo.vo.CommonGroupVO;

/**
 * <p>
 * 创建时间为 下午3:39 2020/3/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICommonGroupService {

    SystemGroupDO findById(Long groupId);

    SystemGroupDO save(SystemGroupDO systemGroup, SystemUserDO systemUser);

    SystemGroupDO update(SystemGroupDO systemGroup, SystemUserDO systemUser);

    void deleteById(Long groupId);
}
