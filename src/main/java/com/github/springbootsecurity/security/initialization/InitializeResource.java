package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
//@DependsOn("initializeRole")
public class InitializeResource implements CommandLineRunner {

    @Resource
    private ISystemResourceRepository resourceRepository;

    @Override
    public void run(String... args) throws Exception {



        SystemResourceDO systemResource = SystemResourceDO.builder()
                .resourceName("注册地址").url("/register").method("GET").note("注册地址。")
                .build();
        resourceRepository.save(systemResource);
    }


}
