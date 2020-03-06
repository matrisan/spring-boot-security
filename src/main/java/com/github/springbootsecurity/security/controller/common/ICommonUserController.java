package com.github.springbootsecurity.security.controller.common;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.validation.group.Save;
import com.github.springbootsecurity.security.validation.group.Update;
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


public interface ICommonUserController {

    /**
     * 查找所有的用户
     *
     * @param pageable       分页信息
     * @param authentication 登录的用户信息
     * @return Page
     */
    ResultDTO<Page<SystemUserDO>> findAll(@NotNull @PageableDefault(direction = Sort.Direction.DESC) Pageable pageable,
                                          @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * 根据ID查找用户
     *
     * @param userId 用户ID
     * @return SystemUserDO
     */
    ResultDTO<SystemUserDO> findById(@PathVariable Long userId);

    /**
     * 新增用户
     *
     * @param systemUser     新增用户信息
     * @param authentication 登录用户信息
     * @return SystemUserDO
     */
    ResultDTO<SystemUserDO> save(@NotNull @Validated({Save.class}) @RequestBody SystemUserDO systemUser,
                                 @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * 更新用户
     *
     * @param systemUser     更新用户信息
     * @param authentication 登录用户信息
     * @return SystemUserDO
     */
    ResultDTO<SystemUserDO> update(@NotNull @Validated({Update.class}) @RequestBody SystemUserDO systemUser,
                                   @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * 根据 ID 删除用户
     *
     * @param userId 用户ID
     * @return Void
     */
    ResultDTO<Void> deleteById(@PathVariable Long userId);

}
