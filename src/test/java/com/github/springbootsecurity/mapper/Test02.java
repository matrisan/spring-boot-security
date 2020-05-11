package com.github.springbootsecurity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springbootsecurity.mapper.pojo.GroupDO;
import com.github.springbootsecurity.mapper.pojo.RoleDO;
import com.github.springbootsecurity.mapper.pojo.UserDO;
import com.github.springbootsecurity.mapper.pojo.UserVO;
import com.google.common.collect.Sets;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

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

public class Test02 {

    public static void main(String[] args) throws JsonProcessingException {
        Set<GroupDO> groups = Sets.newHashSet();
        groups.add(GroupDO.builder().name("name1").build());
        groups.add(GroupDO.builder().name("name2").build());
        UserDO user = UserDO.builder()
                .name("user")
                .group(GroupDO.builder().name("group").groups(groups).build())
                .roles(Sets.newHashSet(RoleDO.builder().name("role").build()))
                .build();


        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//        mapperFactory.classMap(UserDO.class, UserVO.class)
//                .field("name", "name")
//                .field("age", "age")
//                .byDefault()
//                .register();

        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        UserVO userVo = mapperFacade.map(user, UserVO.class);
        System.out.println("UserVO: " + new ObjectMapper().writeValueAsString(userVo));
    }

}
