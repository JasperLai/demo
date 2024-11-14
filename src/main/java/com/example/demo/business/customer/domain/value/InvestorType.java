package com.example.demo.business.customer.domain.value;
public enum InvestorType {
    GENERAL("01", "普通投资者"),
    PROFESSIONAL("02", "专业投资者");

    private final String code;
    private final String desc;

    InvestorType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
} 