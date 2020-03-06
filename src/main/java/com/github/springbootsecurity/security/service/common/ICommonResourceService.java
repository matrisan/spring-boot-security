package com.github.springbootsecurity.security.service.common;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 * 创建时间为 下午4:47 2020/3/1
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICommonResourceService {

    Page<SystemResourceDO> findAll(Pageable pageable, SystemUserDO authentication);

    SystemResourceDO findById(@PathVariable Long resourceId);

}
