package com.github.springbootsecurity.security.controller.common;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;

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


public interface ICommonResourceController {

    /**
     * <p>分页信息</p>
     * 分页查找资源
     *
     * @param pageable     分页信息
     * @param authentication SystemUserDO
     * @return Page
     */
    ResultDTO<Page<SystemResourceDO>> findAll(@NotNull @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                              @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * <p>查询接口</p>
     * 根据 ID 查询资源
     *
     * @param id 资源 ID
     * @return SystemResourceDO
     */
    ResultDTO<SystemResourceDO> findById(@PathVariable Long id);
}
