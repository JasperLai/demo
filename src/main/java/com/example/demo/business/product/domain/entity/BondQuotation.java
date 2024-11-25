package com.example.demo.business.product.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BondQuotation {
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

    // 构造函数
    private BondQuotation() {}
    
    // Builder模式构建器
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private BondQuotation quotation;
        
        private Builder() {
            quotation = new BondQuotation();
        }
        
        public Builder withQuotaTransNo(String quotaTransNo) {
            quotation.quotaTransNo = quotaTransNo;
            return this;
        }
                
        public Builder withProductId(String productId) {
            quotation.productId = productId;
            return this;
        }
        
        public Builder withPriceType(String priceType) {
            quotation.priceType = priceType;
            return this;
        }
        
        public Builder withBondAccruInt(BigDecimal bondAccruInt) {
            quotation.bondAccruInt = bondAccruInt;
            return this;
        }
        
        public Builder withCompBuyNetPrice(BigDecimal compBuyNetPrice) {
            quotation.compBuyNetPrice = compBuyNetPrice;
            return this;
        }
        
        public Builder withCompSellNetPrice(BigDecimal compSellNetPrice) {
            quotation.compSellNetPrice = compSellNetPrice;
            return this;
        }
        
        public Builder withCompBuyFullPrice(BigDecimal compBuyFullPrice) {
            quotation.compBuyFullPrice = compBuyFullPrice;
            return this;
        }
        
        public Builder withCompSellFullPrice(BigDecimal compSellFullPrice) {
            quotation.compSellFullPrice = compSellFullPrice;
            return this;
        }
        
        public Builder withBuyIncomeRate(BigDecimal buyIncomeRate) {
            quotation.buyIncomeRate = buyIncomeRate;
            return this;
        }
        
        public Builder withSellIncomeRate(BigDecimal sellIncomeRate) {
            quotation.sellIncomeRate = sellIncomeRate;
            return this;
        }
        
        public Builder withQuotaTime(Date quotaTime) {
            quotation.quotaTime = quotaTime;
            return this;
        }
        
        public Builder withExpTime(Date expTime) {
            quotation.expTime = expTime;
            return this;
        }
        
        public BondQuotation build() {
            // 设置默认值
            if (quotation.quotaTime == null) {
                quotation.quotaTime = new Date();
            }
            
            // 添加业务校验
            quotation.validate();
            return quotation;
        }
    }

    // 业务方法
    /**
     * 判断报价是否已过期
     */
    public boolean isExpired() {
        return expTime != null && expTime.before(new Date());
    }

    /**
     * 计算买卖价差
     */
    public BigDecimal calculateSpread() {
        if (compSellNetPrice != null && compBuyNetPrice != null) {
            return compSellNetPrice.subtract(compBuyNetPrice);
        }
        return BigDecimal.ZERO;
    }

    /**
     * 计算买入全价
     */
    public void calculateBuyFullPrice() {
        if (compBuyNetPrice != null && bondAccruInt != null) {
            this.compBuyFullPrice = compBuyNetPrice.add(bondAccruInt);
        }
    }

    /**
     * 计算卖出全价
     */
    public void calculateSellFullPrice() {
        if (compSellNetPrice != null && bondAccruInt != null) {
            this.compSellFullPrice = compSellNetPrice.add(bondAccruInt);
        }
    }

    /**
     * 更新报价
     */
    public void updateQuotation(BigDecimal buyNetPrice, BigDecimal sellNetPrice, 
                              BigDecimal buyRate, BigDecimal sellRate) {
        this.compBuyNetPrice = buyNetPrice;
        this.compSellNetPrice = sellNetPrice;
        this.buyIncomeRate = buyRate;
        this.sellIncomeRate = sellRate;
        this.quotaTime = new Date();
        
        calculateBuyFullPrice();
        calculateSellFullPrice();
    }

    /**
     * 业务校验
     */
    private void validate() {
        if (compBuyNetPrice != null && compSellNetPrice != null 
            && compBuyNetPrice.compareTo(compSellNetPrice) >= 0) {
            throw new IllegalArgumentException("买入净价必须小于卖出净价");
        }
        
        if (buyIncomeRate != null && sellIncomeRate != null 
            && buyIncomeRate.compareTo(sellIncomeRate) >= 0) {
            throw new IllegalArgumentException("买入收益率必须小于卖出收益率");
        }
        
        if (expTime != null && expTime.before(quotaTime)) {
            throw new IllegalArgumentException("到期时间不能早于报价时间");
        }
    }

    public String getQuotaTransNo() {
        return quotaTransNo;
    }

    public String getPriceType() {
        return priceType;
    }

    public String getProductId() {
        return productId;
    }

    public BigDecimal getBondAccruInt() {
        return bondAccruInt;
    }

    public BigDecimal getCompBuyNetPrice() {
        return compBuyNetPrice;
    }

    public BigDecimal getCompSellNetPrice() {
        return compSellNetPrice;
    }

    public BigDecimal getCompBuyFullPrice() {
        return compBuyFullPrice;
    }

    public BigDecimal getCompSellFullPrice() {
        return compSellFullPrice;
    }

    public BigDecimal getBuyIncomeRate() {
        return buyIncomeRate;
    }

    public BigDecimal getSellIncomeRate() {
        return sellIncomeRate;
    }

    public Date getQuotaTime() {
        return quotaTime;
    }

    public Date getExpTime() {
        return expTime;
    }
    

}
