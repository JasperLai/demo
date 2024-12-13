package com.example.demo.business.trade.domain.valueobject;

/**
 * 付款类型枚举
 */
public enum CashType {
    INTEREST("01", "付息"),
    PRINCIPAL("02", "兑付");

    private String code;
    private String desc;

    CashType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static CashType fromCode(String code) {
        for (CashType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid CashType code: " + code);
    }
} 