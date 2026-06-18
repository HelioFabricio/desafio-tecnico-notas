package com.panvel.desafiotecnico.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Around( "within(com.panvel.desafiotecnico.service..*) || within(com.panvel.desafiotecnico.validators..*)" )
    public Object measure( ProceedingJoinPoint joinPoint ) throws Throwable {

        long start = System.nanoTime();

        Object result = joinPoint.proceed();

        long durationMs = ( System.nanoTime() - start ) / 1_000_000;

        log.info(
            "{}.{} executou em {} ms",
                joinPoint.getSignature().getDeclaringType().getSimpleName(),
                joinPoint.getSignature().getName(),
                durationMs
        );

        return result;
    }
}