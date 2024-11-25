package com.example.demo.business.product.app.dto.response;

import com.example.demo.business.product.domain.entity.BondQuotation;
import java.math.BigDecimal;
import java.util.Date;

public class BondQuotationDTO {
    private String quotaTransNo;         // 价格来源流水号
    private String priceType;            // 报价业务类型
    private String productId;            // 托管产品编码
    private BigDecimal bondAccruInt;     // 应计利息
    private BigDecimal compBuyNetPrice;  // 单位买入净价
    private BigDecimal compSellNetPrice; // 单位卖出净价
    private BigDecimal compBuyFullPrice; // 单位买入全价
    private BigDecimal compSellFullPrice;// 单位卖出全价
    private BigDecimal buyIncomeRate;    // 银行买入收益率
    private BigDecimal sellIncomeRate;   // 银行卖出收益率
    private Date quotaTime;              // 报价时间
    private Date expTime;                // 最晚有效期

    public static BondQuotationDTO fromEntity(BondQuotation entity) {
        if (entity == null) {
            return null;
        }
        BondQuotationDTO dto = new BondQuotationDTO();
        dto.quotaTransNo = entity.getQuotaTransNo();
        dto.priceType = entity.getPriceType();
        dto.productId = entity.getProductId();
        dto.bondAccruInt = entity.getBondAccruInt();
        dto.compBuyNetPrice = entity.getCompBuyNetPrice();
        dto.compSellNetPrice = entity.getCompSellNetPrice();
        dto.compBuyFullPrice = entity.getCompBuyFullPrice();
        dto.compSellFullPrice = entity.getCompSellFullPrice();
        dto.buyIncomeRate = entity.getBuyIncomeRate();
        dto.sellIncomeRate = entity.getSellIncomeRate();
        dto.quotaTime = entity.getQuotaTime();
        dto.expTime = entity.getExpTime();
        return dto;
    }

    public BondQuotation toEntity() {
        return BondQuotation.builder()
                .withQuotaTransNo(this.quotaTransNo)
                .withPriceType(this.priceType)
                .withProductId(this.productId)
                .withBondAccruInt(this.bondAccruInt)
                .withCompBuyNetPrice(this.compBuyNetPrice)
                .withCompSellNetPrice(this.compSellNetPrice)
                .withCompBuyFullPrice(this.compBuyFullPrice)
                .withCompSellFullPrice(this.compSellFullPrice)
                .withBuyIncomeRate(this.buyIncomeRate)
                .withSellIncomeRate(this.sellIncomeRate)
                .withQuotaTime(this.quotaTime)
                .withExpTime(this.expTime)
                .build();
    }

    // Getters and Setters
    public String getQuotaTransNo() {
        return quotaTransNo;
    }

    public void setQuotaTransNo(String quotaTransNo) {
        this.quotaTransNo = quotaTransNo;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getBondAccruInt() {
        return bondAccruInt;
    }

    public void setBondAccruInt(BigDecimal bondAccruInt) {
        this.bondAccruInt = bondAccruInt;
    }

    public BigDecimal getCompBuyNetPrice() {
        return compBuyNetPrice;
    }

    public void setCompBuyNetPrice(BigDecimal compBuyNetPrice) {
        this.compBuyNetPrice = compBuyNetPrice;
    }

    public BigDecimal getCompSellNetPrice() {
        return compSellNetPrice;
    }

    public void setCompSellNetPrice(BigDecimal compSellNetPrice) {
        this.compSellNetPrice = compSellNetPrice;
    }

    public BigDecimal getCompBuyFullPrice() {
        return compBuyFullPrice;
    }

    public void setCompBuyFullPrice(BigDecimal compBuyFullPrice) {
        this.compBuyFullPrice = compBuyFullPrice;
    }

    public BigDecimal getCompSellFullPrice() {
        return compSellFullPrice;
    }

    public void setCompSellFullPrice(BigDecimal compSellFullPrice) {
        this.compSellFullPrice = compSellFullPrice;
    }

    public BigDecimal getBuyIncomeRate() {
        return buyIncomeRate;
    }

    public void setBuyIncomeRate(BigDecimal buyIncomeRate) {
        this.buyIncomeRate = buyIncomeRate;
    }

    public BigDecimal getSellIncomeRate() {
        return sellIncomeRate;
    }

    public void setSellIncomeRate(BigDecimal sellIncomeRate) {
        this.sellIncomeRate = sellIncomeRate;
    }

    public Date getQuotaTime() {
        return quotaTime;
    }

    public void setQuotaTime(Date quotaTime) {
        this.quotaTime = quotaTime;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }
} 