package com.example.demo.business.product.domain.valueObject;

public enum CustodyOrg {
    SH_CLEARING_HOUSE("上海清算所"),
    CCDC("中债登");

    private final String displayName;

    CustodyOrg(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void main(String[] args) {
        // 示例用法
        CustodyOrg org1 = CustodyOrg.SH_CLEARING_HOUSE;
        CustodyOrg org2 = CustodyOrg.CCDC;

        System.out.println("托管机构1: " + org1.getDisplayName());
        System.out.println("托管机构2: " + org2.getDisplayName());
    }
}

