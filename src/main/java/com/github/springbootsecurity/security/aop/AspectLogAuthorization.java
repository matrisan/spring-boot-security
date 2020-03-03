package com.github.springbootsecurity.security.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 创建时间为 下午4:15 2020/2/28
 * 项目名称 spring-boot-security
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

@Slf4j
@Aspect
@Component
public class AspectLogAuthorization {

    @Pointcut("execution(* com.github.springbootsecurity.security.authorization.*.*(..))")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {

        long before = System.currentTimeMillis();
        Object result = pdj.proceed();
        long after = System.currentTimeMillis();
        log.info("{}-{}-{}", (after - before), pdj.getSignature().toShortString(), JSON.toJSONString(pdj.getArgs()));
        return result;
    }


}
