package com.example.demo.business.trade.domain.valueobject;

/**
 * 付息兑付计划状态枚举
 */
public enum CashPlanStatus {
    PENDING("PENDING", "待处理"),
    PROCESSING("PROCESSING", "处理中"), 
    COMPLETED("COMPLETED", "已完成"),
    FAILED("FAILED", "处理失败");

    private String code;
    private String desc;

    CashPlanStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CashPlanStatus fromCode(String code) {
        for (CashPlanStatus status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid CashPlanStatus code: " + code);
    }
} 