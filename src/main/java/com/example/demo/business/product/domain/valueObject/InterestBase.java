package com.example.demo.business.product.domain.valueObject;

public enum InterestBase {
    //TODO 参照 ddm 标准定义
    ACT366(1, "按 366 日/年计息"),
    ACT360(2, "按 360 日/年计息"),
    ACT365(3, "按 365 日/年计息"),
    ACTACT(4, "按年实际天数计息"),
    T30360(5, "每月 30 日,每年 360 日");

    private final int code;
    private final String description;

    InterestBase(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
