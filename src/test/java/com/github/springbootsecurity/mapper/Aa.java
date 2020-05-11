package com.github.springbootsecurity.mapper;

import com.github.springbootsecurity.mapper.pojo.GroupDO;
import com.github.springbootsecurity.mapper.pojo.RoleDO;
import com.github.springbootsecurity.mapper.pojo.UserDO;
import com.github.springbootsecurity.mapper.pojo.UserVO;
import com.google.common.collect.Sets;

import java.util.Set;

/**
 * <p>
 * 创建时间为 下午5:22 2020/5/10
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class Aa {

    public static void main(String[] args) {
        Set<GroupDO> groups = Sets.newHashSet();
        groups.add(GroupDO.builder().name("name1").build());
        groups.add(GroupDO.builder().name("name2").build());
        UserDO user = UserDO.builder()
                .name("user")
                .group(GroupDO.builder().name("group").groups(groups).build())
                .roles(Sets.newHashSet(RoleDO.builder().name("role").build()))
                .build();
        UserVO vo = IUserMapper.INSTANCE.converter(user);
        System.out.println(vo);
    }

}
