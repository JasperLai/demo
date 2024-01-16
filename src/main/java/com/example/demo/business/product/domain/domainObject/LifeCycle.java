package com.example.demo.business.product.domain.domainObject;

public enum LifeCycle {
    ISSUE_BEFORE(100, "发行前"),
    ISSUE_IN_PROGRESS(200, "发行中"),
    LISTING_IN_CIRCULATION(300, "上市流通期"),
    LISTING_INTEREST_BEFORE(301, "上市流通付息前"),
    LISTING_REDEMPTION_BEFORE(302, "上市流通兑付前");

    private final int code;
    private final String description;

    LifeCycle(int code, String description) {
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

