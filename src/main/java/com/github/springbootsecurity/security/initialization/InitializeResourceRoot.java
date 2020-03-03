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
public class InitializeResourceRoot implements CommandLineRunner {

    @Resource
    private ISystemResourceRepository resourceRepository;

    private static final Table<String, String, String> DATA = HashBasedTable.create();

    static {
        DATA.put("组织架构1", "GET", "/system/root/group");
        DATA.put("组织架构2", "GET", "/system/root/group/*");
        DATA.put("组织架构3", "POST", "/system/root/group");
        DATA.put("组织架构4", "PUT", "/system/root/group");
        DATA.put("组织架构5", "DELETE", "/system/root/group/*");
    }
    static {
        DATA.put("资源1", "GET", "/system/root/resource");
        DATA.put("资源2", "GET", "/system/root/resource/*");
        DATA.put("资源3", "POST", "/system/root/resource");
        DATA.put("资源4", "PUT", "/system/root/resource");
        DATA.put("资源5", "DELETE", "/system/root/resource/*");
    }
    static {
        DATA.put("角色1", "GET", "/system/root/role");
        DATA.put("角色2", "GET", "/system/root/role/*");
        DATA.put("角色3", "POST", "/system/root/role");
        DATA.put("角色4", "PUT", "/system/root/role");
        DATA.put("角色5", "DELETE", "/system/root/role/*");
    }
    static {
        DATA.put("用户1", "GET", "/system/root/user");
        DATA.put("用户2", "GET", "/system/root/user/*");
        DATA.put("用户3", "POST", "/system/root/user");
        DATA.put("用户4", "PUT", "/system/root/user");
        DATA.put("用户5", "DELETE", "/system/root/user/*");
    }



    @Override
    public void run(String... args) throws Exception {
        DATA.cellSet().forEach(one -> {
            if (!resourceRepository.existsByUrlEqualsAndMethodEquals(one.getValue(), one.getColumnKey())) {
                resourceRepository.save(SystemResourceDO.builder()
                        .resourceName(one.getRowKey())
                        .method(one.getColumnKey())
                        .url(one.getValue())
                        .resourceNote(one.getRowKey())
                        .build());
            }
        });
    }


}
