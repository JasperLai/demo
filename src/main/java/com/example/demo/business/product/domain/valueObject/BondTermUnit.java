package com.example.demo.business.product.domain.valueObject;

public enum BondTermUnit {
    YEAR("1", "0", "年"),
    MONTH("2", "1", "月"),
    DAY("3", "2", "日");

    private final String sourceCode; // BondRegistDTO中的代码
    private final String targetCode; // 系统中的代码
    private final String description;

    BondTermUnit(String sourceCode, String targetCode, String description) {
        this.sourceCode = sourceCode;
        this.targetCode = targetCode;
        this.description = description;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public String getDescription() {
        return description;
    }

    public static String convertToTargetCode(String sourceCode) {
        for (BondTermUnit unit : values()) {
            if (unit.sourceCode.equals(sourceCode)) {
                return unit.targetCode;
            }
        }
        throw new IllegalArgumentException("不支持的期限单位: " + sourceCode);
    }
} 