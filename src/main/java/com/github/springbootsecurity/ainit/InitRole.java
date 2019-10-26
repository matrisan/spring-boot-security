package com.github.springbootsecurity.ainit;

import com.github.springbootsecurity.pojo.doo.SystemRoleDO;
import com.github.springbootsecurity.pojo.vo.SystemRoleVO;
import com.github.springbootsecurity.service.application.IRootSystemRoleService;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午12:29 2019/10/23
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */


@Component
public class InitRole {

    @Resource
    private IRootSystemRoleService roleService;

    private static final List<String> LIST = Lists.newArrayList("ROLE_ROOT", "ROLE_ADMIN", "ROLE_USER");

//    @PostConstruct
    public void init() {
        Pageable pageable = PageRequest.of(0, 1000);
        Page<SystemRoleVO> page = roleService.findAllRoles(pageable);
        Set<String> set = page.stream().map(SystemRoleVO::getName).filter(one -> !LIST.contains(one)).collect(Collectors.toSet());
        set.forEach(one -> roleService.saveRole(SystemRoleDO.builder().name(one).note("note : " + one).build()));
    }


}
