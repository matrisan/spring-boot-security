package com.github.springbootsecurity.security.authorization;

import com.github.springbootsecurity.security.pojo.table.SystemGroupDO;
import com.github.springbootsecurity.security.pojo.table.SystemUserDO;
import com.google.common.collect.Sets;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 * 创建时间为 下午4:10 2020/2/27
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Service
public class AuthorizeGroupService {

    public boolean hasGroupPermission(@NotNull Authentication authentication, long groupId) {
        Set<Long> groupIds = Sets.newHashSet();
        SystemUserDO systemUser = (SystemUserDO) authentication.getPrincipal();
        SystemGroupDO group = systemUser.getSystemGroup();
        getAllGroupId(group, groupIds);
        return groupIds.contains(groupId);
    }

    private void getAllGroupId(@NotNull SystemGroupDO group, @NotNull Set<Long> groupIds) {
        groupIds.add(group.getGroupId());
        for (SystemGroupDO groupDO : group.getChildGroup()) {
            groupIds.add(group.getGroupId());
            if (groupDO.getChildGroup().size() > 0) {
                getAllGroupId(groupDO, groupIds);
            }
        }
    }

}
