package com.example.demo.business.customer.domain.value;

import java.util.Objects;

public class CustAcctNum {
    private final String value;

    private CustAcctNum(String value) {
        this.value = value;
    }

    public static CustAcctNum of(String areaCode, String sequenceNumber) {
        String combinedValue = combineValue(areaCode, sequenceNumber);
        validate(combinedValue);
        return new CustAcctNum(combinedValue);
    }

    private static String combineValue(String areaCode, String sequenceNumber) {
        // TODO: 实现具体的托管账号组合规则
        // 例如：地区代码(4位) + 序列号(8位) = 托管账号
        return String.format("%s%s", areaCode, sequenceNumber);
    }

    private static void validate(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("托管账号不能为空");
        }
        // TODO: 添加托管账号的其他业务规则验证
        // 例如：
        // 1. 地区代码必须是有效的行政区划代码
        // 2. 序列号必须是指定长度的数字
        // 3. 总长度验证
        // 4. 格式验证等
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustAcctNum that = (CustAcctNum) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
} 