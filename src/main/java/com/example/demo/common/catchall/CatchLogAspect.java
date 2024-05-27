package com.example.demo.common.catchall;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.common.exception.BizException;


@Aspect
@Component
@EnableAspectJAutoProxy
public class CatchLogAspect {


    private static final Logger log = LogManager.getLogger(CatchLogAspect.class);

    /**
     * The syntax of pointcut : https://blog.csdn.net/zhengchao1991/article/details/53391244
     */
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
            response = handleException(joinPoint, e);
        } finally {
            logResponse(startTime, response);
        }

        return response;
    }

    private Object handleException(ProceedingJoinPoint joinPoint, Throwable e) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        @SuppressWarnings("rawtypes")
        Class returnType = ms.getReturnType();

        if (e instanceof BizException) {
            log.warn("BIZ EXCEPTION : " + e.getMessage());       
            return new DefaultResponseHandler().handle(returnType, ((BizException) e).getErrCode(), e.getMessage());
        }

        log.error("UNKNOWN EXCEPTION :");
        log.error(e.getMessage(), e);

        return new DefaultResponseHandler().handle(returnType, "UNKNOWN_ERROR", e.getMessage());
    }

    private void logResponse(long startTime, Object response) {
        try {
            long endTime = System.currentTimeMillis();
            log.debug("RESPONSE : " + JSON.toJSONString(response));
            log.debug("COST : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            //swallow it
            log.error("logResponse error : " + e);
        }
    }

    private void logRequest(ProceedingJoinPoint joinPoint) {
        try {
            if (!log.isDebugEnabled()) {
                return;
            }
            log.debug("START PROCESSING: " + joinPoint.getSignature().toShortString());
            Object[] args = joinPoint.getArgs();
            for (Object arg : args) {
                log.debug("REQUEST : " + JSON.toJSONString(arg, SerializerFeature.IgnoreErrorGetter));
            }
        } catch (Exception e) {
            //swallow it
            log.error("logReqeust error : " + e);
        }
    }

}
