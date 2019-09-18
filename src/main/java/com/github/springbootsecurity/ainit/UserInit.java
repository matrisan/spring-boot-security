package com.github.springbootsecurity.ainit;

import com.github.springbootsecurity.pojo.UserInfoDO;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * 创建时间为 下午7:50 2019/9/17
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class UserInit {

    @Resource(name = "userInfo")
    private ConcurrentHashMap<String, UserInfoDO> map;

    @Resource
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        map.put("user", getUser("user"));
        map.put("admin", getAdmin("admin"));
        map.put("root", getRoot("root"));
    }

    private UserInfoDO getUser(String username) {
        return UserInfoDO.builder().username(username)
                .password(passwordEncoder.encode("shaodong"))
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .accountNonExpired(true).build();
    }

    private UserInfoDO getAdmin(String username) {
        return UserInfoDO.builder().username(username)
                .password(passwordEncoder.encode("shaodong"))
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")))
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .accountNonExpired(true).build();
    }

    private UserInfoDO getRoot(String username) {
        return UserInfoDO.builder().username(username)
                .password(passwordEncoder.encode("shaodong"))
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_ROOT")))
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .accountNonExpired(true).build();
    }

}
