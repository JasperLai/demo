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
    private final String originalCode;
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
}
