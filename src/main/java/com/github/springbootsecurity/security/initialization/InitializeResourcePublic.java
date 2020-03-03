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
public class InitializeResourcePublic implements CommandLineRunner {

    @Resource
    private ISystemResourceRepository resourceRepository;

    private static final Table<String, String, String> DATA = HashBasedTable.create();

    static {
        DATA.put("/", "GET", "注册地址");
        DATA.put("/register", "POST", "注册地址");
        DATA.put("/system/ops/group", "GET", "注册地址");
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
