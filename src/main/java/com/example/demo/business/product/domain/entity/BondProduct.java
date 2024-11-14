package com.example.demo.business.product.domain.entity;

import com.example.demo.business.product.domain.valueObject.BondLifeCycle;
import com.example.demo.business.product.domain.valueObject.FDMProductCode;
import com.example.demo.business.product.domain.valueObject.ProductCode;
import java.math.BigDecimal;

public class BondProduct {
    private ProductCode productCode;              // 产品编码152029+序号
    private FDMProductCode FDMCode;               // 账务核算产品代码
    private Bond bond;                            // 债券
    private BondBusinessAuth authority;           // 业务权限
    private String saleArea;                      // 销售区域
    private String sellableCustomerType;          // 可售客户类别
    private String sellableCustomerRiskLevel;     // 可售客户风险等级
    private String pledgeableSign;            // 可质押标志
    private String reissueFlag;               // 续发行标志
    private BigDecimal reissueIncomeRate;     // 续发行到期收益率
    private String recommendFlag;             // 推荐标志
    private String quotaMode;                 // 报价模式 手动自动
    private String bidSpread;                 // 买价点差
    private String askSpread;                 // 卖价点差
    private long upperLimitHolding = Long.MAX_VALUE;  // 银行持有上限
    private long lowerLimitHolding = 0;              // 银行持有下限
    

    private BondProduct() {
    }

    public static BondProduct builder() {
        return new BondProduct();
    }

    public BondProduct withProductCode(String bondCode) {
        this.productCode = ProductCode.create(bondCode);
        return this;
    }

    public BondProduct withFDMCode(String bondCode) {
        this.FDMCode = FDMProductCode.create(bondCode);
        return this;
    }

    public BondProduct withBond(Bond bond) {
        this.bond = bond;
        return this;
    }

    public BondProduct withAuthority(BondBusinessAuth authority) {
        this.authority = authority;
        return this;
    }

    public BondProduct withSaleArea(String saleArea) {
        this.saleArea = saleArea;
        return this;
    }

    public BondProduct withSellableCustomerType(String type) {
        this.sellableCustomerType = type;
        return this;
    }

    // 在链式初始化完成后，可以调用 build 方法获取最终的对象
    public BondProduct build() {
        return this;
    }

    
    public void setProductCode(ProductCode productCode) {
        this.productCode = productCode;
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

    public void setUpperLimitHolding(long upperLimitHolding) {
        this.upperLimitHolding = upperLimitHolding;
    }

    public long getLowerLimitHolding() {
        return lowerLimitHolding;
    }

    public void setLowerLimitHolding(long lowerLimitHolding) {
        this.lowerLimitHolding = lowerLimitHolding;
    }

    public String getProductCode() {
        return this.productCode.getCode();
    }


    public String getFDMCode() {
        return this.FDMCode.getCode();
    }


    public Bond getBond() {
        return this.bond;
    }

    // public void setBond(Bond bond) {
    //     this.bond = bond;
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
     * @return
     */
    public BondLifeCycle getLifeCycle(){
        return null;
    }

    /**
     *  TODO 根据产品编码判断是否续发行
     * @return
     */
    public boolean isReissue(){
        return true;
    }

}
