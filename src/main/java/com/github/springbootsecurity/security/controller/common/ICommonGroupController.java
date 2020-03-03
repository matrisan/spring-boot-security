package com.github.springbootsecurity.security.controller.common;

import com.github.springbootsecurity.security.pojo.common.ResultDTO;
import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.github.springbootsecurity.security.validated.Save;
import com.github.springbootsecurity.security.validated.Update;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 创建时间为 下午3:06 2020/2/28
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public interface ICommonGroupController {

    /**
     * <p>查询接口<p/>
     * 根据 ID 获取组织架构信息
     *
     * @param groupId 组织架构信息
     * @return SystemGroupDO
     */
    ResultDTO<SystemGroupDO> findById(@PathVariable Long groupId);

    /**
     * <p>保存接口</p>
     * 保存一个组织架构，会自动挂载到本组织下面
     *
     * @param systemGroup    组织架构信息
     * @param authentication 当前登录的用户信息
     * @return SystemGroupDO
     */
    ResultDTO<SystemGroupDO> save(@NotNull @Validated({Save.class}) @RequestBody SystemGroupDO systemGroup,
                                  @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * <p>更新接口</p>
     * 更新一个组织架构
     *
     * @param systemGroup    组织架构信息
     * @param authentication 当前登录的用户信息
     * @return SystemGroupDO
     */
    ResultDTO<SystemGroupDO> update(@NotNull @Validated({Update.class}) @RequestBody SystemGroupDO systemGroup,
                                    @NotNull @AuthenticationPrincipal SystemUserDO authentication);

    /**
     * <p>删除接口</p>
     * 需要下属的组织架构没有任何用户和角色
     *
     * @param groupId 组织架构的 ID
     * @return Void
     */
    ResultDTO<Void> deleteById(@PathVariable Long groupId);

}
