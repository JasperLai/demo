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
import org.springframework.web.client.RestClientException;

import com.example.demo.common.event.EventBus;
import com.example.demo.common.event.PaymentTimeoutEvent;
import com.example.demo.common.event.PaymentFailureEvent;
import com.example.demo.common.exception.BizException;

import com.example.demo.common.context.TradeContext;
@Aspect
@Component
@EnableAspectJAutoProxy
public class CatchLogAspect {
    private static final Logger log = LogManager.getLogger(CatchLogAspect.class);

    @Autowired
    private DefaultResponseHandler responseHandler;

    @Autowired
    private EventBus eventBus;

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
            
            if (isPaymentMethod(ms)) {
                handlePaymentException(e, joinPoint);
            }
            
            response = responseHandler.handle(ms.getReturnType(), e);
        } finally {
            logResponse(startTime, response);
        }
        
        return response;
    }

    private void handlePaymentException(Throwable e, ProceedingJoinPoint joinPoint) {
        String txTraceNum = extractTxTraceNum(joinPoint);
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        
        if (e instanceof RestClientException) {
            eventBus.publish(new PaymentTimeoutEvent(
                (RestClientException)e,
                txTraceNum,
                ms,
                joinPoint.getArgs()
            ));
        } else if (e instanceof BizException) {
            eventBus.publish(new PaymentFailureEvent(
                (BizException)e,
                txTraceNum,
                ms,
                joinPoint.getArgs()
            ));
        }
    }

    private String extractTxTraceNum(ProceedingJoinPoint joinPoint) {
        return TradeContext.getTraceNum();
    }

    private boolean isPaymentMethod(MethodSignature ms) {
        return ms.getMethod().getName().equals("processBondSubscribe") 
            || ms.getMethod().getName().toLowerCase().contains("payment");
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
