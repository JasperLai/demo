package com.example.demo.business.product.domain.entity;

import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.domain.valueObject.BondLifeCycle;
import com.example.demo.business.product.domain.valueObject.FDMProductCode;
import com.example.demo.business.product.domain.valueObject.ProductId;
import java.math.BigDecimal;

public class BondProduct {
    private ProductId productId; // 产品编码152029+序号
    private FDMProductCode FDMCode; // 账务核算产品代码
    private Bond bond; // 债券
    private BondBusinessAuth authority; // 业务权限
    private String saleArea; // 销售区域
    private String sellableCustomerType; // 可售客户类别
    private String sellableCustomerRiskLevel; // 可售客户风险等级
    private String pledgeableSign; // 可质押标志
    private String reissueFlag; // 续发行标志
    private BigDecimal reissueIncomeRate; // 续发行到期收益率
    private String recommendFlag; // 推荐标志
    private String quotaMode; // 报价模式 手动自动
    private String bidSpread; // 买价点差
    private String askSpread; // 卖价点差
    private Long upperLimitHolding = Long.MAX_VALUE; // 银行持有上限
    private Long lowerLimitHolding = 0L; // 银行持有下限

    private BondProduct() {
    }

    public static Builder builder() {
        return new Builder();
    }

    // 内部构建器类
    public static class Builder {
        private BondProduct product;

        public Builder() {
            product = new BondProduct();
        }

        public Builder withProductCode(String bondCode) {
            product.setProductId(ProductId.create(bondCode));
            return this;
        }

        public Builder withFDMCode(String bondCode) {
            product.setFDMCode(FDMProductCode.create(bondCode));
            return this;
        }

        public Builder withBond(Bond bond) {
            product.setBond(bond);
            return this;
        }

        public Builder withAuthority(BondBusinessAuth authority) {
            product.setAuthority(authority);
            return this;
        }

        public Builder withSaleArea(String saleArea) {
            product.setSaleArea(saleArea);
            return this;
        }

        public Builder withSellableCustomerType(String type) {
            product.setSellableCustomerType(type);
            return this;
        }

        public BondProduct build() {
            return product;
        }
    }

    public void setProductId(ProductId productCode) {
        this.productId = productCode;
    }

    public void setFDMCode(FDMProductCode fDMCode) {
        FDMCode = fDMCode;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getSellableCustomerType() {
        return sellableCustomerType;
    }

    public void setSellableCustomerType(String sellableCustomerType) {
        this.sellableCustomerType = sellableCustomerType;
    }

    public String getSellableCustomerRiskLevel() {
        return sellableCustomerRiskLevel;
    }

    public void setSellableCustomerRiskLevel(String sellableCustomerRiskLevel) {
        this.sellableCustomerRiskLevel = sellableCustomerRiskLevel;
    }

    public String getPledgeableSign() {
        return pledgeableSign;
    }

    public void setPledgeableSign(String pledgeableSign) {
        this.pledgeableSign = pledgeableSign;
    }

    public String getReissueFlag() {
        return reissueFlag;
    }

    public void setReissueFlag(String reissueFlag) {
        this.reissueFlag = reissueFlag;
    }

    public BigDecimal getReissueIncomeRate() {
        return reissueIncomeRate;
    }

    public void setReissueIncomeRate(BigDecimal reissueIncomeRate) {
        this.reissueIncomeRate = reissueIncomeRate;
    }

    public String getRecommendFlag() {
        return recommendFlag;
    }

    public void setRecommendFlag(String recommendFlag) {
        this.recommendFlag = recommendFlag;
    }

    public String getQuotaMode() {
        return quotaMode;
    }

    public void setQuotaMode(String quotaMode) {
        this.quotaMode = quotaMode;
    }

    public String getBidSpread() {
        return bidSpread;
    }

    public void setBidSpread(String bidSpread) {
        this.bidSpread = bidSpread;
    }

    public String getAskSpread() {
        return askSpread;
    }

    public void setAskSpread(String askSpread) {
        this.askSpread = askSpread;
    }

    public long getUpperLimitHolding() {
        return upperLimitHolding;
    }

    public void setUpperLimitHolding(Long upperLimitHolding) {
        this.upperLimitHolding = upperLimitHolding;
    }

    public long getLowerLimitHolding() {
        return lowerLimitHolding;
    }

    public void setLowerLimitHolding(Long lowerLimitHolding) {
        this.lowerLimitHolding = lowerLimitHolding;
    }

    public String getProductId() {
        return this.productId.getCode();
    }

    public String getFDMCode() {
        return this.FDMCode.getCode();
    }

    public Bond getBond() {
        return this.bond;
    }

    // public void setBond(Bond bond) {
    // this.bond = bond;
    // }

    public BondBusinessAuth getAuthority() {
        return this.authority;
    }

    public void setAuthority(BondBusinessAuth authority) {
        this.authority = authority;
    }

    /**
     * 获取产品生命周期，发行前，发行中，上市流通期
     * TODO 根据 bond 的日期参数，和当前日期，判断生命周期
     * 
     * @return
     */
    public BondLifeCycle getLifeCycle() {
        return null;
    }

    /**
     * TODO 根据产品编码判断是否续发行
     * 
     * @return
     */
    public boolean isReissue() {
        return true;
    }

    public void updateFromDTO(BondProductDTO dto) {
        if (dto.getSaleArea() != null) {
            this.saleArea = dto.getSaleArea();
        }
        if (dto.getSellableCustomerType() != null) {
            this.sellableCustomerType = dto.getSellableCustomerType();
        }
        if (dto.getSellableCustomerRiskLevel() != null) {
            this.sellableCustomerRiskLevel = dto.getSellableCustomerRiskLevel();
        }
        if (dto.getPledgeableSign() != null) {
            this.pledgeableSign = dto.getPledgeableSign();
        }
        if (dto.getReissueFlag() != null) {
            this.reissueFlag = dto.getReissueFlag();
        }
        if (dto.getReissueIncomeRate() != null) {
            this.reissueIncomeRate = dto.getReissueIncomeRate();
        }
        if (dto.getRecommendFlag() != null) {
            this.recommendFlag = dto.getRecommendFlag();
        }
        if (dto.getQuotaMode() != null) {
            this.quotaMode = dto.getQuotaMode();
        }
        if (dto.getBidSpread() != null) {
            this.bidSpread = dto.getBidSpread();
        }
        if (dto.getAskSpread() != null) {
            this.askSpread = dto.getAskSpread();
        }
        if (dto.getUpperLimitHolding() != null) {
            this.upperLimitHolding = dto.getUpperLimitHolding();
        }
        if (dto.getLowerLimitHolding() != null) {
            this.lowerLimitHolding = dto.getLowerLimitHolding();
        }
    }

}
