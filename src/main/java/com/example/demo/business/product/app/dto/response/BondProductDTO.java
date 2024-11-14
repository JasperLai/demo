package com.example.demo.business.product.app.dto.response;

import com.example.demo.common.exception.data.BaseData;
import java.math.BigDecimal;
import java.util.Date;

public class BondProductDTO extends BaseData{
    // BondProduct 相关字段
    private String productCode;              // 产品编码
    private String fdmProductCode;           // FDM产品编码
    private String saleArea;                 // 销售区域
    private String sellableCustomerType;     // 可售客户类别
    private String sellableCustomerRiskLevel;// 可售客户风险等级
    private String pledgeableSign;           // 可质押标志
    private String reissueFlag;              // 续发行标志
    private BigDecimal reissueIncomeRate;    // 续发行到期收益率
    private String recommendFlag;            // 推荐标志
    private String quotaMode;                // 报价模式
    private String bidSpread;                // 买价点差
    private String askSpread;                // 卖价点差
    private Long upperLimitHolding;          // 银行持有上限
    private Long lowerLimitHolding;          // 银行持有下限

    // Bond 相关字段
    private String bondCode;                 // 债券代码
    private String shortName;                // 债券简称
    private String bondVariety;              // 债券品种
    private Integer bondTerm;                // 债券期限
    private BigDecimal coupon;               // 票面利率
    private String currency;                 // 币种
    private BigDecimal issuePrice;           // 发行价格
    private Integer transferPauseDayBeforeCash; // 付息兑付日转托管业务停止天数
    private Date matureDate;                 // 到期日
    private Date issueEndDate;               // 发行结束日
    private Date listingDate;                // 上市流通日
    private Date accrualDate;                // 起息日
    private Date issueDate;                  // 发行日
    private String accrualBase;              // 计息基础
    private String accrualMethod;            // 计息方式
    private Integer parValue;                // 面值
    private String custodyOrg;               // 托管机构
    private Date businessDate;               // 业务日期
    private String bondStatus;               // 债券状态
    private Integer addTimes;                // 追加次数
    private String bondPauseStatus;          // 债券暂停状态
    private Date bondRegistrationDate;       // 债权登记日
    private Date principalValueEffectiveDate;// 本金值生效日
    private Date firstInterestPaymentDate;   // 第一次付息日
    private String interestPaymentCycle;     // 付息周期
    private Date interestPaymentDate;        // 本计息期付息日
    private String bondTermUnit;             // 债券期限单位
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getFdmProductCode() {
        return fdmProductCode;
    }
    public void setFdmProductCode(String fdmProductCode) {
        this.fdmProductCode = fdmProductCode;
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
    public Long getUpperLimitHolding() {
        return upperLimitHolding;
    }
    public void setUpperLimitHolding(Long upperLimitHolding) {
        this.upperLimitHolding = upperLimitHolding;
    }
    public Long getLowerLimitHolding() {
        return lowerLimitHolding;
    }
    public void setLowerLimitHolding(Long lowerLimitHolding) {
        this.lowerLimitHolding = lowerLimitHolding;
    }
    public String getBondCode() {
        return bondCode;
    }
    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getBondVariety() {
        return bondVariety;
    }
    public void setBondVariety(String bondVariety) {
        this.bondVariety = bondVariety;
    }
    public Integer getBondTerm() {
        return bondTerm;
    }
    public void setBondTerm(Integer bondTerm) {
        this.bondTerm = bondTerm;
    }
    public BigDecimal getCoupon() {
        return coupon;
    }
    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public BigDecimal getIssuePrice() {
        return issuePrice;
    }
    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }
    public Integer getTransferPauseDayBeforeCash() {
        return transferPauseDayBeforeCash;
    }
    public void setTransferPauseDayBeforeCash(Integer transferPauseDayBeforeCash) {
        this.transferPauseDayBeforeCash = transferPauseDayBeforeCash;
    }
    public Date getMatureDate() {
        return matureDate;
    }
    public void setMatureDate(Date matureDate) {
        this.matureDate = matureDate;
    }
    public Date getIssueEndDate() {
        return issueEndDate;
    }
    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }
    public Date getListingDate() {
        return listingDate;
    }
    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }
    public Date getAccrualDate() {
        return accrualDate;
    }
    public void setAccrualDate(Date accrualDate) {
        this.accrualDate = accrualDate;
    }
    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    public String getAccrualBase() {
        return accrualBase;
    }
    public void setAccrualBase(String accrualBase) {
        this.accrualBase = accrualBase;
    }
    public String getAccrualMethod() {
        return accrualMethod;
    }
    public void setAccrualMethod(String accrualMethod) {
        this.accrualMethod = accrualMethod;
    }
    public Integer getParValue() {
        return parValue;
    }
    public void setParValue(Integer parValue) {
        this.parValue = parValue;
    }
    public String getCustodyOrg() {
        return custodyOrg;
    }
    public void setCustodyOrg(String custodyOrg) {
        this.custodyOrg = custodyOrg;
    }
    public Date getBusinessDate() {
        return businessDate;
    }
    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }
    public String getBondStatus() {
        return bondStatus;
    }
    public void setBondStatus(String bondStatus) {
        this.bondStatus = bondStatus;
    }
    public Integer getAddTimes() {
        return addTimes;
    }
    public void setAddTimes(Integer addTimes) {
        this.addTimes = addTimes;
    }
    public String getBondPauseStatus() {
        return bondPauseStatus;
    }
    public void setBondPauseStatus(String bondPauseStatus) {
        this.bondPauseStatus = bondPauseStatus;
    }
    public Date getBondRegistrationDate() {
        return bondRegistrationDate;
    }
    public void setBondRegistrationDate(Date bondRegistrationDate) {
        this.bondRegistrationDate = bondRegistrationDate;
    }
    public Date getPrincipalValueEffectiveDate() {
        return principalValueEffectiveDate;
    }
    public void setPrincipalValueEffectiveDate(Date principalValueEffectiveDate) {
        this.principalValueEffectiveDate = principalValueEffectiveDate;
    }
    public Date getFirstInterestPaymentDate() {
        return firstInterestPaymentDate;
    }
    public void setFirstInterestPaymentDate(Date firstInterestPaymentDate) {
        this.firstInterestPaymentDate = firstInterestPaymentDate;
    }
    public String getInterestPaymentCycle() {
        return interestPaymentCycle;
    }
    public void setInterestPaymentCycle(String interestPaymentCycle) {
        this.interestPaymentCycle = interestPaymentCycle;
    }
    public Date getInterestPaymentDate() {
        return interestPaymentDate;
    }
    public void setInterestPaymentDate(Date interestPaymentDate) {
        this.interestPaymentDate = interestPaymentDate;
    }
    public String getBondTermUnit() {
        return bondTermUnit;
    }
    public void setBondTermUnit(String bondTermUnit) {
        this.bondTermUnit = bondTermUnit;
    }

    // 生成所有字段的 getter/setter 方法
    // ... getter/setter 方法 ...
    
}
