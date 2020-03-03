package com.github.springbootsecurity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/**
 * <p>
 * 创建时间为 下午1:53 2020/3/2
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


public class BeanUtilsTest {

    @Test
    public void test01() throws InvocationTargetException, IllegalAccessException {
        UserDO userDo = UserDO.builder().username("TEST_NAME").roles(Collections.singleton(RoleDO.builder().name("ROLE_NAME").build())).build();
        UserVO userVo = new UserVO();

        System.out.println();
        BeanUtils.copyProperties(userVo, userDo);
        System.out.println(userDo.toString());
        System.out.println(userVo.toString());
    }


    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    static class UserDO {

        private String username;

        private Set<RoleDO> roles;

    }

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    static class UserVO {

        private String username;

        private Set<RoleVO> roles;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    static class RoleDO {

        private String name;

    }

    @Getter
    @Setter
    @Builder
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    static class RoleVO {

        private String name;

    }


}
