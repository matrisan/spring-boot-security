package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.pojo.table.SystemResourceDO;
import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
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
public class InitializeResourceCommon implements CommandLineRunner {

    @Resource
    private ISystemResourceRepository resourceRepository;

    private static final Table<String, String, String> DATA = HashBasedTable.create();

    static {
        DATA.put("/system/common/group", "GET", "组织架构1");
        DATA.put("/system/common/group/*", "GET", "组织架构2");
        DATA.put("/system/common/group", "POST", "组织架构3");
        DATA.put("/system/common/group", "PUT", "组织架构4");
        DATA.put("/system/common/group/*", "DELETE", "组织架构5");
    }

    static {
        DATA.put("/system/common/resource", "GET", "资源1");
        DATA.put("/system/common/resource/*", "GET", "资源2");
        DATA.put("/system/common/resource", "POST", "资源3");
        DATA.put("/system/common/resource", "PUT", "资源4");
        DATA.put("/system/common/resource/*", "DELETE", "资源5");
    }

    static {
        DATA.put("/system/common/role", "GET", "角色1");
        DATA.put("/system/common/role/*", "GET", "角色2");
        DATA.put("/system/common/role", "POST", "角色3");
        DATA.put("/system/common/role", "PUT", "角色4");
        DATA.put("/system/common/role/*", "DELETE", "角色5");
    }

    static {
        DATA.put("/system/common/user", "GET", "用户1");
        DATA.put("/system/common/user/*", "GET", "用户2");
        DATA.put("/system/common/user", "POST", "用户3");
        DATA.put("/system/common/user", "PUT", "用户4");
        DATA.put("/system/common/user/*", "DELETE", "用户5");
    }


    @Override
    public void run(String... args) throws Exception {
        DATA.cellSet().forEach(one -> {
            if (!resourceRepository.existsByUrlEqualsAndMethodEquals(one.getValue(), one.getColumnKey())) {
                resourceRepository.save(SystemResourceDO.builder()
                        .resourceName(one.getValue())
                        .method(one.getColumnKey())
                        .url(one.getRowKey())
                        .resourceNote(one.getValue())
                        .build());
            }
        });
    }
}
