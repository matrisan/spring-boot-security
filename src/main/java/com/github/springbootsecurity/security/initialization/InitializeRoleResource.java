package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.google.common.collect.Sets;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 创建时间为 下午2:31 2020/2/26
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
@DependsOn({"initializeRole", "initializeResourceCommon", "initializeResourceCenter"})
public class InitializeRoleResource implements CommandLineRunner {

    @Resource
    private ISystemRoleRepository roleRepository;

    @Resource
    private ISystemResourceRepository resourceRepository;

    private static final Set<String> PREFIX_VIP = Sets.newHashSet();
    private static final Set<String> PREFIX_TRIAL = Sets.newHashSet();

    static {
        PREFIX_VIP.add("/system/common/");
        PREFIX_VIP.add("/system/center/user");
        PREFIX_VIP.add("/report");
    }

    static {
        PREFIX_TRIAL.add("/system/center/user");
        PREFIX_TRIAL.add("/report");
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.findByRoleNameEquals("ROLE_VIP").ifPresent(systemRoleDO -> {
            systemRoleDO.setSystemResources(
                    PREFIX_VIP.stream().flatMap(
                            one -> resourceRepository.findAllByUrlStartsWith(one).stream()).collect(Collectors.toSet()
                    )
            );
            roleRepository.save(systemRoleDO);
        });

        roleRepository.findByRoleNameEquals("ROLE_TRIAL").ifPresent(systemRoleDO -> {
            systemRoleDO.setSystemResources(
                    PREFIX_TRIAL.stream().flatMap(
                            one -> resourceRepository.findAllByUrlStartsWith(one).stream()).collect(Collectors.toSet()
                    )
            );
            roleRepository.save(systemRoleDO);
        });


    }


}
