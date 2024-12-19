package com.example.demo.common.event;

import org.aspectj.lang.reflect.MethodSignature;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.springframework.web.client.ResourceAccessException;

public class PaymentTimeoutEvent extends BaseEvent {
    private final Exception exception;
    private final String txTraceNum;

    public PaymentTimeoutEvent(Exception exception, 
                             String txTraceNum,
                             MethodSignature signature, 
                             Object[] args) {
        super(signature, args);
        this.exception = exception;
        this.txTraceNum = txTraceNum;
    }

    public Exception getException() {
        return exception;
    }

    public String getTxTraceNum() {
        return txTraceNum;
    }

    public boolean isTimeout() {
        if (exception instanceof SocketTimeoutException) {
            return true;
        }
        if (exception instanceof ResourceAccessException) {
            return exception.getCause() instanceof SocketTimeoutException;
        }
        return false;
    }

    public boolean isConnectionReset() {
        if (exception instanceof SocketException) {
            return exception.getMessage().contains("Connection reset");
        }
        if (exception instanceof ResourceAccessException) {
            Throwable cause = exception.getCause();
            return cause instanceof SocketException 
                && cause.getMessage().contains("Connection reset");
        }
        return false;
    }

    public boolean isConnectionRefused() {
        if (exception instanceof ConnectException) {
            return exception.getMessage().contains("Connection refused");
        }
        if (exception instanceof ResourceAccessException) {
            Throwable cause = exception.getCause();
            return cause instanceof ConnectException 
                && cause.getMessage().contains("Connection refused");
        }
        return false;
    }
} 