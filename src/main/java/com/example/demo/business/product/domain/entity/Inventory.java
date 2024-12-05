package com.example.demo.business.product.domain.entity;

public class Inventory {
    private String orgNum;
    private String productId;
    private String bondCode;
    private Long limits;
    private SaleStrategy saleStrategy;

    public enum SaleStrategy {
        global,
        specific
    }

    // 私有构造函数,使用Builder模式
    private Inventory() {}

    public static Builder builder() {
        return new Builder();
    }

    // Builder类
    public static class Builder {
        private Inventory inventory;

        public Builder() {
            inventory = new Inventory();
        }

        public Builder withOrgNum(String orgNum) {
            inventory.setOrgNum(orgNum);
            return this;
        }

        public Builder withProductId(String productId) {
            inventory.setProductId(productId);
            return this;
        }

        public Builder withBondCode(String bondCode) {
            inventory.setBondCode(bondCode);
            return this;
        }

        public Builder withLimits(Long limits) {
            inventory.setLimits(limits);
            return this;
        }

        public Builder withSaleStrategy(SaleStrategy saleStrategy) {
            inventory.setSaleStrategy(saleStrategy);
            return this;
        }

        public Inventory build() {
            return inventory;
        }
    }

    // Getters and Setters
    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public Long getLimits() {
        return limits;
    }

    public void setLimits(Long limits) {
        this.limits = limits;
    }

    public SaleStrategy getSaleStrategy() {
        return saleStrategy;
    }

    public void setSaleStrategy(SaleStrategy saleStrategy) {
        this.saleStrategy = saleStrategy;
    }
}

