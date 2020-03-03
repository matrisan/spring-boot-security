package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.pojo.table.SystemRoleDO;
import com.github.springbootsecurity.security.repository.ISystemRoleRepository;
import com.google.common.collect.Maps;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

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
public class InitializeRole implements CommandLineRunner {

    @Resource
    private ISystemRoleRepository roleRepository;

    private static final Map<String, String> INIT_ROLES = Maps.newHashMap();

    static {
        INIT_ROLES.put("ROLE_ROOT", "超管用户");
        INIT_ROLES.put("ROLE_TRIAL", "试用用户");
        INIT_ROLES.put("ROLE_VIP", "VIP用户");
    }

    @Override
    public void run(String... args) throws Exception {
        for (Map.Entry<String, String> entry : INIT_ROLES.entrySet()) {
            if (!roleRepository.existsByRoleNameEquals(entry.getKey())) {
                roleRepository.save(creatRole(entry.getKey(), entry.getValue()));
            }
        }
    }


    private SystemRoleDO creatRole(String roleName, String note) {
        return SystemRoleDO.builder().roleName(roleName).roleNote(note).build();
    }


}
