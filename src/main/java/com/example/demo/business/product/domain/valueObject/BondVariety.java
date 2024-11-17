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
    
    /**
     * 根据代码获取债券品种枚举值
     * @param code 债券品种代码
     * @return 对应的债券品种枚举值
     * @throws BusinessException 当找不到对应的债券品种时抛出异常
     */
    public static BondVariety fromCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return null;
        }
        
        for (BondVariety variety : BondVariety.values()) {
            if (variety.getCode().equals(code.trim())) {
                return variety;
            }
        }
        
        return null;
    }
    
    /**
     * 判断给定的代码是否是有效的债券品种代码
     * @param code 待验证的债券品种代码
     * @return 如果是有效的债券品种代码返回true，否则返回false
     */
    public static boolean isValidCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            return false;
        }
        
        for (BondVariety variety : BondVariety.values()) {
            if (variety.getCode().equals(code.trim())) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("%s(%s)", this.name(), this.description);
    }
}
