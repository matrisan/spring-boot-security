package com.github.springbootsecurity.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * <p>
 * 创建时间为 下午12:40 2019/9/18
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Aspect
@Component
public class AspectLog {

    @Pointcut("execution(* com.github.springbootsecurity.controller.impl.*.*(..))")
    public void pointCut() {
    }

    /**
     * 环绕通知:手动引导代码执行
     *
     * @param pdj 可执行体
     * @return return
     * @throws Throwable Throwable
     */
    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        System.out.println("运行...参数列表是:{" + Arrays.asList(pdj.getArgs()) + "}");
        return pdj.proceed();
    }

}
