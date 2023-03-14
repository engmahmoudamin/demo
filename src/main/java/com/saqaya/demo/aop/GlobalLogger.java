package com.saqaya.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GlobalLogger {

    @Around("execution(* com.saqaya.demo..*.*(..)) " +
            " && !execution(* com.saqaya.demo.security..*.*(..)) " +
            " && !execution(* com.saqaya.demo.mapper..*.*(..)) " +
            " && !execution(* com.saqaya.demo.configuration..*.*(..)) " +
            " && !execution(* com.saqaya.demo.repository..*.*(..)) ")
    public Object logger(ProceedingJoinPoint jp) throws Throwable {
        Object res;
        String methodName = jp.getSignature().getName();
        String className = jp.getSignature().getDeclaringTypeName();
        className = className.substring(className.lastIndexOf('.') + 1);
        Object[] args = jp.getArgs();

        log.info("{} -> {} : {}", className, methodName, (args != null) ? args.length : "");

        res = jp.proceed(args);

        log.info("{} -> {} : {}", className, methodName, (res != null && res.getClass() != null) ? res.getClass().getName() : "");

        return res;
    }
}
