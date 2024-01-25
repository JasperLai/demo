package com.example.demo.business.product.domain.valueObject;

public enum InterestType {
    //TODO 参照 DDM 标准定义
    MONTH("B01", "按月结息"),
    SEASON("B02", "按季结息"),
    YEAR("B03", "按年结息"),
    NOTFIXED("B04", "不定期结息"),
    ZERO("B05", "零息"),
    SEMIYEAR("B06", "按半年结息"),
    SIMPLE("B07", "利随本清"),
    OTHER("B99", "其他");

    private final String code;
    private final String description;

    InterestType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
