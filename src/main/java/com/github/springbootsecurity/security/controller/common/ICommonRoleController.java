package com.github.springbootsecurity.security.controller.common;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.validated.Save;
import com.github.springbootsecurity.security.validated.Update;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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


public interface ICommonRoleController {

    /**
     * <p>查找接口</p>
     * 分页查找所有的角色信息
     *
     * @param pageable       分页信息
     * @param authentication 用户信息
     * @return Page
     */
    ResultDTO<Page<SystemRoleDO>> findAll(@NotNull @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                          @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * <p>查找接口</p>
     * 根据角色的 ID 查找角色
     *
     * @param roleId 角色的 ID
     * @return SystemRoleDO
     */
    ResultDTO<SystemRoleDO> findById(@PathVariable Long roleId);

    /**
     * 为当前组织机构新增一个角色
     *
     * @param systemRole     角色信息
     * @param authentication 用户信息
     * @return SystemRoleDO
     */
    ResultDTO<SystemRoleDO> save(@NotNull @Validated({Save.class}) @RequestBody SystemRoleDO systemRole,
                                 @NotNull @AuthenticationPrincipal SystemUserDO authentication);


    /**
     * 修改当前组织架构的的角色信息
     *
     * @param systemRole     角色信息
     * @param authentication 用户信息
     * @return SystemRoleDO
     */
    ResultDTO<SystemRoleDO> update(@NotNull @Validated({Update.class}) @RequestBody SystemRoleDO systemRole,
                                   @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * 删除指定角色
     *
     * @param roleId 角色的ID
     * @return Void
     */
    ResultDTO<Void> deleteById(@PathVariable Long roleId);

}
