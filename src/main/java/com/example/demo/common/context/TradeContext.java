package com.example.demo.common.context;

public class TradeContext {
    private static final ThreadLocal<String> TRACE_NUM_CONTEXT = new ThreadLocal<>();
    
    public static void setTraceNum(String traceNum) {
        TRACE_NUM_CONTEXT.set(traceNum);
    }
    
    public static String getTraceNum() {
        return TRACE_NUM_CONTEXT.get();
    }
    
    public static void clear() {
        TRACE_NUM_CONTEXT.remove();
    }
} 