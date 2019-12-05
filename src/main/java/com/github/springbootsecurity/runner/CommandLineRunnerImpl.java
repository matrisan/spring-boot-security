package com.github.springbootsecurity.runner;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

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
//@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Resource
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Set<String> setNames = Sets.newHashSet(context.getBeanDefinitionNames());
        setNames.forEach(one -> {
            Class clz = context.getBean(one).getClass();
            Method[] methods = clz.getDeclaredMethods();
            if (StringUtils.contains(clz.getName(),"Controller")) {
                System.out.println(clz.getName());
                for (Method method : methods) {
                    for (Annotation annotation : method.getAnnotations()) {
                        System.out.println(annotation.getClass().getName());
                    }
                    System.out.println();
                }
                System.out.println();
            }
        });


    }
}
