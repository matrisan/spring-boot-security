package com.github.springbootsecurity.security.authorization;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 创建时间为 上午12:23 2020/2/28
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class AuthorizeUserService {


    /**
     * 判断当前用户是否有 该用户组的ID 的操作权限
     *
     * @param authentication Authentication
     * @param groupId        用户所属组 ID
     * @return boolean
     */
    public boolean hasGroupPermission(@NotNull Authentication authentication, long groupId) {
        // TODO
        return true;
    }

    /**
     * 当对用户编辑时，要校验原来是否有原来组的权限(groupId1),以及新的组的权限(groupId2)
     *
     * @param authentication Authentication
     * @param groupId1       用户原来所属组 ID
     * @param groupId2       用户现在所属组 ID
     * @return boolean
     */
    public boolean hasGroupPermission(@NotNull Authentication authentication, long groupId1, long groupId2) {
        // TODO
        return true;
    }

    /**
     * 获取某个用户的信息，校验是否有这个用户的权限.
     * 首先获取到用户所属组{@link SystemUserDO#getSystemGroup()};
     * 在通过所属组 {@link SystemGroupDO#getChildGroup()}获取到子组；
     * 在从子组中获取到所有的用户 {@link SystemGroupDO#getSystemUsers()}。
     *
     * @param authentication Authentication
     * @param userId         用户的ID
     * @return boolean
     */
    public boolean hasUserPermission(@NotNull Authentication authentication, long userId) {
        SystemUserDO systemUser = (SystemUserDO) authentication.getPrincipal();
        return containsUserId(systemUser.getSystemGroup(), userId);
    }

    private boolean containsUserId(@NotNull SystemGroupDO systemGroup, long userId) {
        for (SystemUserDO systemUser : systemGroup.getSystemUsers()) {
            if (systemUser.getUserId() == userId) {
                return true;
            }
        }
        for (SystemGroupDO groupDO : systemGroup.getChildGroup()) {
            return containsUserId(groupDO, userId);
        }
        return false;
    }

}
