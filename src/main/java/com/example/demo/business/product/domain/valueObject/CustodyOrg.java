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

    /**
     * 根据显示名称获取托管机构枚举值
     * @param name 托管机构显示名称
     * @return 对应的托管机构枚举值，如果未找到则返回null
     */
    public static CustodyOrg fromCode(String name) {
        if (name == null || name.trim().isEmpty()) {
            return null;
        }
        
        String trimmedName = name.trim();
        for (CustodyOrg org : CustodyOrg.values()) {
            if (org.getDisplayName().equals(trimmedName)) {
                return org;
            }
        }
        
        return null;
    }

    /**
     * 根据枚举名称获取托管机构枚举值
     * @param enumName 托管机构枚举名称
     * @return 对应的托管机构枚举值，如果未找到则返回null
     */
    public static CustodyOrg fromEnumName(String enumName) {
        if (enumName == null || enumName.trim().isEmpty()) {
            return null;
        }
        
        try {
            return CustodyOrg.valueOf(enumName.trim());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        // 示例用法
        CustodyOrg org1 = CustodyOrg.SH_CLEARING_HOUSE;
        CustodyOrg org2 = CustodyOrg.CCDC;

        System.out.println("托管机构1: " + org1.getDisplayName());
        System.out.println("托管机构2: " + org2.getDisplayName());
    }
}

