package com.example.demo.common.event;

import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.client.RestClientException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.ConnectException;

public class PaymentTimeoutEvent extends BaseEvent {
    private final RestClientException exception;
    private final String txTraceNum;

    public PaymentTimeoutEvent(RestClientException exception, 
                             String txTraceNum,
                             MethodSignature signature, 
                             Object[] args) {
        super(signature, args);
        this.exception = exception;
        this.txTraceNum = txTraceNum;
    }

    public RestClientException getException() {
        return exception;
    }

    public String getTxTraceNum() {
        return txTraceNum;
    }

    public boolean isTimeout() {
        return exception.getRootCause() instanceof SocketTimeoutException;
    }

    public boolean isConnectionReset() {
        return exception.getRootCause() instanceof SocketException 
            && exception.getRootCause().getMessage().contains("Connection reset");
    }

    public boolean isConnectionRefused() {
        return exception.getRootCause() instanceof ConnectException 
            && exception.getRootCause().getMessage().contains("Connection refused");
    }
} 