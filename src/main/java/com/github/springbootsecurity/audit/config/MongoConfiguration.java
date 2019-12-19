package com.github.springbootsecurity.audit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.MongoConfigurationSupport;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午1:04 2019/12/19
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

//@Primary
@Configuration
public class MongoConfiguration  {

    @Resource
    private MongoMappingContext context;

    @PostConstruct
    public void init(){
        System.out.println(context.isAutoIndexCreation());
    }
}