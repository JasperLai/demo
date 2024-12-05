package com.example.demo.business.product.app.dto.response;

import com.example.demo.business.product.domain.entity.Inventory;
import com.example.demo.business.product.domain.entity.Inventory.SaleStrategy;

public class InventoryDTO {
    private String orgNum;
    private String productId;
    private String bondCode;
    private Long limits;
    private String saleStrategy;

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

    public String getSaleStrategy() {
        return saleStrategy;
    }

    public void setSaleStrategy(String saleStrategy) {
        this.saleStrategy = saleStrategy;
    }

    // 转换方法
    public static InventoryDTO fromEntity(Inventory entity) {
        if (entity == null) {
            return null;
        }
        InventoryDTO dto = new InventoryDTO();
        dto.setOrgNum(entity.getOrgNum());
        dto.setProductId(entity.getProductId());
        dto.setBondCode(entity.getBondCode());
        dto.setLimits(entity.getLimits());
        dto.setSaleStrategy(entity.getSaleStrategy().name());
        return dto;
    }

    public Inventory toEntity() {
        return Inventory.builder()
                .withOrgNum(this.orgNum)
                .withProductId(this.productId)
                .withBondCode(this.bondCode)
                .withLimits(this.limits)
                .withSaleStrategy(SaleStrategy.valueOf(this.saleStrategy))
                .build();
    }
} 