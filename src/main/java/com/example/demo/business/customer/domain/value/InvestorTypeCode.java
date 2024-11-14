package com.example.demo.business.customer.domain.value;
public enum InvestorTypeCode {
    PERSONAL("01", "个人"),
    INSTITUTION("02", "机构");

    private final String code;
    private final String desc;

    InvestorTypeCode(String code, String desc) {
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