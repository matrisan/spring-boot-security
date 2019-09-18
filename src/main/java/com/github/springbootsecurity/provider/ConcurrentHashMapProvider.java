package com.github.springbootsecurity.provider;

import com.github.springbootsecurity.pojo.UserBookDO;
import com.github.springbootsecurity.pojo.UserInfoDO;
import com.github.springbootsecurity.pojo.UserRoleDO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 创建时间为 下午8:22 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class ConcurrentHashMapProvider {

    @Bean
    public ConcurrentHashMap<String, UserBookDO> userBook() {
        return new ConcurrentHashMap<>(16);
    }

    @Bean
    public ConcurrentHashMap<String, UserInfoDO> userInfo() {
        return new ConcurrentHashMap<>(16);
    }

    @Bean
    public ConcurrentHashMap<String, UserRoleDO> userRole() {
        return new ConcurrentHashMap<>(16);
    }

}
