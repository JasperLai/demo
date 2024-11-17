package com.example.demo.business.product.domain.valueObject;
import java.util.ArrayList;
import java.util.List;


public enum AccrualMethod {
    // TODO 参照中债标准定义
    DISCOUNTING("10", "-1", "贴现"),
    FULLREPAYMENT("20", "3", "利随本清"),
    FIXRATE("31", "0", "固定利率"),
    FLOATRATE("32", "1", "浮动利率"),
    ZEROCOUPON("40", "2", "零息"),
    OTHER("99", "-2", "无");

    private final String code;
    private final String originalCode; //原系统字段类型
    private final String description;
    private static final List<AccrualMethod> list = new ArrayList<>();

    static {
        for (AccrualMethod method : AccrualMethod.values()) {
            list.add(method);
        }
    }

    AccrualMethod(String code, String originalCode, String description) {
        this.code = code;
        this.originalCode = originalCode;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getOriginalCode() {
        return originalCode;
    }

    public String getDescription() {
        return description;
    }

    public static List<AccrualMethod> getList() {
        return list;
    }

    /**
     * 根据代码获取计息方式枚举值
     * @param code 计息方式代码
     * @return 对应的计息方式枚举值，如果未找到则返回null
     */
    public static AccrualMethod fromCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        
        String trimmedCode = code.trim();
        for (AccrualMethod method : AccrualMethod.values()) {
            if (method.getCode().equals(trimmedCode) || 
                method.getOriginalCode().equals(trimmedCode)) {
                return method;
            }
        }
        
        return null;
    }

    /**
     * 根据原系统代码获取计息方式枚举值
     * @param originalCode 原系统计息方式代码
     * @return 对应的计息方式枚举值，如果未找到则返回null
     */
    public static AccrualMethod fromOriginalCode(String originalCode) {
        if (originalCode == null || originalCode.trim().isEmpty()) {
            return null;
        }
        
        String trimmedCode = originalCode.trim();
        for (AccrualMethod method : AccrualMethod.values()) {
            if (method.getOriginalCode().equals(trimmedCode)) {
                return method;
            }
        }
        
        return null;
    }
}
