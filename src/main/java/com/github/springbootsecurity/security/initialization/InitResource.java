package com.github.springbootsecurity.security.initialization;

import com.github.springbootsecurity.security.pojo.SystemResourceDO;
import com.github.springbootsecurity.security.repository.ISystemResourceRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午12:46 2020/2/25
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Component
public class InitResource {

    @Resource
    private ISystemResourceRepository repository;

    @PostConstruct
    public void init() {
        SystemResourceDO resource1 = SystemResourceDO.builder()
                .resourceName("hello")
                .url("/hello")
                .method("get")
                .note("test")
                .build();
        repository.save(resource1);
        SystemResourceDO resource2 = SystemResourceDO.builder()
                .resourceName("index")
                .url("/")
                .method("get")
                .note("index")
                .build();
        repository.save(resource2);
    }

}
