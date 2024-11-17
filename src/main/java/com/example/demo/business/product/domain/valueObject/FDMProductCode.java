package com.example.demo.business.product.domain.valueObject;

public class FDMProductCode {
    private final String code;

    private FDMProductCode(String code) {
        validateCode(code);
        this.code = code;
    }

    public static FDMProductCode create(String bondCode) {
        return new FDMProductCode("040521" + bondCode);
    }

    public String getCode() {
        return code;
    }

    private void validateCode(String code) {
        // 在这里添加对产品代码的校验逻辑
        // 例如，可以检查长度、字符类型等
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("FDM code cannot be null or empty");
        }
        // 添加其他校验逻辑...
    }

    public static FDMProductCode of(String fdmProductCode) {
        return new FDMProductCode(fdmProductCode);
    }
}

