package com.example.demo.business.product.domain.valueObject;


public enum BondVariety {
    //DDM 标准定义
    BEARER_BOND("GB01", "凭证式国债"),
    TREASURY_BOND("GB02", "储蓄国债(电子式)"),
    REGISTED_BOND("GB03", "记账式债券"),
    GENERAL_OBLIGATION_BOND("GB041", "地方政府一般债券"),
    SPECIAL_OBLIGATION_BOND("GB042", "地方政府专项债券"),
    CENTRAL_BANK_NOTE("CBN", "中央银行票据"),
    POLICY_BANK_BOND("FB00", "政策性银行债券"),
    COMMERCIAL_BANK_GENERAL_BOND("FB01", "商业银行普通债"),
    COMMERCIAL_BANK_SUB_BOND("FB02", "商业银行次级债"),
    COMMERCIAL_BANK_MIXED_BOND("FB03", "商业银行混合资本债");

    private final String code;
    private final String description;

    BondVariety(String code, String description) {
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
