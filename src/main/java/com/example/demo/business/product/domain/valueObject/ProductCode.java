package com.example.demo.business.product.domain.valueObject;

public class ProductCode {

    private final String code;

    private ProductCode(String code) {
        validateCode(code);
        this.code = code;
    }

    public static ProductCode create(String bondCode) {
        return new ProductCode("CH" + bondCode);
    }

    public String getCode() {
        return code;
    }

    private void validateCode(String code) {
        // 在这里添加对产品代码的校验逻辑
        // 例如，可以检查长度、字符类型等
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Product code cannot be null or empty");
        }
        // 添加其他校验逻辑...
    }
}
