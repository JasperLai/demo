package com.example.demo.business.general.client;

public enum TradeType {

    OPEN_ACCOUNT("001", "开户"),
    DESTROY_ACCOUNT("002", "销户"),
    DISTRIBUTION("003", "分销"),
    PURCHASE("004", "现券"),
    REPO("005", "回购"),
    FREEZE("006", "冻结"),
    DEFREEZE("007", "解冻"),
    PLEDGE("008", "质押"),
    UNPLEDGE("009", "解押"),
    SET_SWITCH("103", "产品交易开关设置"),
    BOND_QUOTA_TRANSFER("104", "债券额度调拨"),
    PRODUCT_ENTER("105", "债券录入"),
    TRADER_ENTER("106", "交易商录入"),
    BANK_BUY("201", "银行买入"),
    BANK_SELL("202", "银行卖出");

    private final String code;
    private final String name;

    // Constructor for the enum
    TradeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getter for code
    public String getCode() {
        return code;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Method to get enum by code
    public static TradeType getByCode(String code) {
        for (TradeType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching TradeType for code: " + code);
    }
}

