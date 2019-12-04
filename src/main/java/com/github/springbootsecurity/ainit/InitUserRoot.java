//package com.github.springbootsecurity.ainit;
//
//import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
//import com.github.springbootsecurity.pojo.doo.SystemUserDO;
//import com.github.springbootsecurity.repository.ISystemRoleJpaRepository;
//import com.github.springbootsecurity.repository.ISystemUserJpaRepository;
//import com.google.common.collect.Sets;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.util.Set;
//
///**
// * <p>
// * 创建时间为 上午10:57 2019/10/21
// * 项目名称 spring-boot-security
// * </p>
// *
// * @author 石少东
// * @version 0.0.1
// * @since 0.0.1
// */
//
////@DependsOn("initRole")
//@Component
//public class InitUserRoot {
//
//    @Resource
//    private PasswordEncoder passwordEncoder;
//
//    @Resource
//    private ISystemUserJpaRepository repository;
//    @Resource
//    private ISystemRoleJpaRepository roleJpaRepository;
//
//    @PostConstruct
//    public void init() {
//        SystemRoleDO roleDO1 = SystemRoleDO.builder().authority("ROLE_ROOT").build();
//        SystemUserDO systemUser1 = SystemUserDO.builder()
//                .username("root")
//                .password(passwordEncoder.encode("123456"))
//                .authorities(Sets.newHashSet(roleDO1))
//                .email("shaopro@qq.com")
//                .credentialsNonExpired(true)
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .enabled(true)
//                .note("root user")
//                .build();
//        roleJpaRepository.save(roleDO1);
//        repository.save(systemUser1);
//
//        SystemRoleDO roleDO2 = SystemRoleDO.builder().authority("ROLE_ROOT").build();
//        SystemUserDO systemUser2 = SystemUserDO.builder()
//                .username("admin")
//                .password(passwordEncoder.encode("123456"))
//                .authorities(Sets.newHashSet(roleDO2))
//                .email("shaopro@qq.com")
//                .credentialsNonExpired(true)
//                .accountNonExpired(true)
//                .accountNonLocked(true)
//                .enabled(true)
//                .note("root user")
//                .build();
//        roleJpaRepository.save(roleDO2);
//        repository.save(systemUser2);
//    }
//
//}
