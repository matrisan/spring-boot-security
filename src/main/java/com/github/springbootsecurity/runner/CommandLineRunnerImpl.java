package com.github.springbootsecurity.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 * 创建时间为 上午10:48 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Resource
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {

    }
}
