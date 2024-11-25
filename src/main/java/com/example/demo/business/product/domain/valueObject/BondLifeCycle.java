package com.example.demo.business.product.domain.valueObject;

public enum BondLifeCycle {
    ISSUE_BEFORE("000", "发行前"),
    ISSUEING_PERIOD("102", "发行中"),
    LISTING_PERIOD("202", "上市流通期"),
    BOND_END("999", "结束");

    private final String code;
    private final String description;

    BondLifeCycle(String code, String description) {
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

