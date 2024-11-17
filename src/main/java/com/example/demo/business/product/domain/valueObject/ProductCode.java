package com.example.demo.business.product.domain.valueObject;

public class ProductCode {
    private static final String PREFIX = "152029";
    private static long sequence = 0; // 简单实现，实际应该使用分布式序列生成器
    private final String code;

    private ProductCode(String code) {
        validateCode(code);
        this.code = code;
    }

    public static ProductCode create(String ignored) {
        // 生成6位序列号，不足6位前面补0
        String sequenceStr = String.format("%06d", ++sequence);
        return new ProductCode(PREFIX + sequenceStr);
    }

    public static ProductCode of(String code) {
        return new ProductCode(code);
    }

    public String getCode() {
        return code;
    }

    private void validateCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Product code cannot be null or empty");
        }
        if (!code.startsWith(PREFIX)) {
            throw new IllegalArgumentException("Product code must start with " + PREFIX);
        }
        if (code.length() != 12) { // 6位前缀 + 6位序列号
            throw new IllegalArgumentException("Product code must be 12 digits");
        }
        if (!code.substring(PREFIX.length()).matches("\\d{6}")) {
            throw new IllegalArgumentException("Product code sequence must be 6 digits");
        }
    }
}
