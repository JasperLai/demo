package com.example.demo.common.event;

import org.aspectj.lang.reflect.MethodSignature;
import com.example.demo.common.exception.BizException;

public class PaymentFailureEvent extends BaseEvent {
    private final BizException exception;
    private final String txTraceNum;

    public PaymentFailureEvent(BizException exception, 
                             String txTraceNum,
                             MethodSignature signature, 
                             Object[] args) {
        super(signature, args);
        this.exception = exception;
        this.txTraceNum = txTraceNum;
    }

    public BizException getException() {
        return exception;
    }

    public String getTxTraceNum() {
        return txTraceNum;
    }
} 