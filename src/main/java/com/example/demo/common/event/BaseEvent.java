package com.example.demo.common.event;

import org.aspectj.lang.reflect.MethodSignature;

public abstract class BaseEvent {
    private final String methodName;
    private final Object[] args;
    private final String className;
    private final long timestamp;

    public BaseEvent(MethodSignature signature, Object[] args) {
        this.methodName = signature.getMethod().getName();
        this.className = signature.getDeclaringType().getName();
        this.args = args;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getClassName() {
        return className;
    }

    public long getTimestamp() {
        return timestamp;
    }
} 