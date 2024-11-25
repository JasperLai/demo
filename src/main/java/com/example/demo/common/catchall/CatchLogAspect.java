package com.example.demo.common.catchall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class CatchLogAspect {
    private static final Logger log = LogManager.getLogger(CatchLogAspect.class);

    @Autowired
    private DefaultResponseHandler responseHandler;

    @Pointcut("@within(CatchAndLog) && execution(public * *(..))")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        logRequest(joinPoint);

        Object response = null;
        try {
            response = joinPoint.proceed();
        } catch (Throwable e) {
            MethodSignature ms = (MethodSignature) joinPoint.getSignature();
            response = responseHandler.handle(ms.getReturnType(), e);
        } finally {
            logResponse(startTime, response);
        }

        return response;
    }

    private void logResponse(long startTime, Object response) {
        try {
            long endTime = System.currentTimeMillis();
            log.debug("RESPONSE : {}", response);
            log.debug("COST : {}ms", (endTime - startTime));
        } catch (Exception e) {
            log.error("记录响应日志失败", e);
        }
    }

    private void logRequest(ProceedingJoinPoint joinPoint) {
        try {
            if (!log.isDebugEnabled()) {
                return;
            }
            log.debug("START PROCESSING: {}", joinPoint.getSignature().toShortString());
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                log.debug("REQUEST : {}", arg);
            }
        } catch (Exception e) {
            log.error("记录请求日志失败", e);
        }
    }
}
