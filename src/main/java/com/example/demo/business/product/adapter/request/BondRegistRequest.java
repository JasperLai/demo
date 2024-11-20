package com.example.demo.business.product.adapter.request;

import org.springframework.lang.NonNull;

public class BondRegistRequest {

    // 业务日期 格式：YYYY-MM-DD
    @NonNull
    private String businessDate;

    // 债券代码
    @NonNull
    private String bondCode;

    // 债券简称
    @NonNull
    private String bondShortName;

    // 债券性质
    @NonNull
    private String bondNature;

    // 记账币种 只支持 CNY
    @NonNull
    private String denominatedCurrency;

    // 债券期限
    @NonNull
    private String bondTerm;

    // 债券期限单位 1-年 2-月 3-日
    @NonNull
    private String bondTermUnit;

    // 债券发行价格
    @NonNull
    private String bondIssuePrice;

    // 计息方式 10-贴现 20-利随本清 31-附息式固定利率 32-附息式浮动利率 40-零息 99-无
    @NonNull
    private String interestCalculationMethod;

    // 付息周期
    private String interestPaymentCycle;

    // 票面利率
    private String couponRate;

    // 发行开始日
    @NonNull
    private String issueStartDate;

    // 起息日
    @NonNull
    private String interestStartDate;

    // 分销开始日
    @NonNull
    private String distributionStartDate;

    // 分销结束日
    @NonNull
    private String distributionEndDate;

    // 上市流通日
    private String listingDate;

    // 本计息期付息日
    private String interestPaymentDate;

    // 到期日
    @NonNull
    private String maturityDate;

    // 债券状态 00-正常 01-到期兑付
    @NonNull
    private String bondStatus;

    // 追加次数
    @NonNull
    private String addTimes;

    // 债券暂停状态 1-正常 2-暂停
    @NonNull
    private String bondPauseStatus;

    // 债权登记日
    private String bondRegistrationDate;

    // 当前本金值
    @NonNull
    private String currentPrincipalValue;

    // 本金值生效日
    private String principalValueEffectiveDate;

    // 第一次付息日
    private String firstInterestPaymentDate;

    // 截止过户日
    @NonNull
    private String cutoffTransferDate;

    public String getBusinessDate() {
        return this.businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getBondCode() {
        return this.bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondShortName() {
        return this.bondShortName;
    }

    public void setBondShortName(String bondShortName) {
        this.bondShortName = bondShortName;
    }

    public String getBondNature() {
        return this.bondNature;
    }

    public void setBondNature(String bondNature) {
        this.bondNature = bondNature;
    }

    public String getDenominatedCurrency() {
        return this.denominatedCurrency;
    }

    public void setDenominatedCurrency(String denominatedCurrency) {
        this.denominatedCurrency = denominatedCurrency;
    }

    public String getBondTerm() {
        return this.bondTerm;
    }

    public void setBondTerm(String bondTerm) {
        this.bondTerm = bondTerm;
    }

    public String getBondTermUnit() {
        return this.bondTermUnit;
    }

    public void setBondTermUnit(String bondTermUnit) {
        this.bondTermUnit = bondTermUnit;
    }

    public String getBondIssuePrice() {
        return this.bondIssuePrice;
    }

    public void setBondIssuePrice(String bondIssuePrice) {
        this.bondIssuePrice = bondIssuePrice;
    }

    public String getInterestCalculationMethod() {
        return this.interestCalculationMethod;
    }

    public void setInterestCalculationMethod(String interestCalculationMethod) {
        this.interestCalculationMethod = interestCalculationMethod;
    }

    public String getInterestPaymentCycle() {
        return this.interestPaymentCycle;
    }

    public void setInterestPaymentCycle(String interestPaymentCycle) {
        this.interestPaymentCycle = interestPaymentCycle;
    }

    public String getCouponRate() {
        return this.couponRate;
    }

    public void setCouponRate(String couponRate) {
        this.couponRate = couponRate;
    }

    public String getIssueStartDate() {
        return this.issueStartDate;
    }

    public void setIssueStartDate(String issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public String getInterestStartDate() {
        return this.interestStartDate;
    }

    public void setInterestStartDate(String interestStartDate) {
        this.interestStartDate = interestStartDate;
    }

    public String getDistributionStartDate() {
        return this.distributionStartDate;
    }

    public void setDistributionStartDate(String distributionStartDate) {
        this.distributionStartDate = distributionStartDate;
    }

    public String getDistributionEndDate() {
        return this.distributionEndDate;
    }

    public void setDistributionEndDate(String distributionEndDate) {
        this.distributionEndDate = distributionEndDate;
    }

    public String getListingDate() {
        return this.listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }

    public String getInterestPaymentDate() {
        return this.interestPaymentDate;
    }

    public void setInterestPaymentDate(String interestPaymentDate) {
        this.interestPaymentDate = interestPaymentDate;
    }

    public String getMaturityDate() {
        return this.maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getBondStatus() {
        return this.bondStatus;
    }

    public void setBondStatus(String bondStatus) {
        this.bondStatus = bondStatus;
    }

    public String getAddTimes() {
        return this.addTimes;
    }

    public void setAddTimes(String addTimes) {
        this.addTimes = addTimes;
    }

    public String getBondPauseStatus() {
        return this.bondPauseStatus;
    }

    public void setBondPauseStatus(String bondPauseStatus) {
        this.bondPauseStatus = bondPauseStatus;
    }

    public String getBondRegistrationDate() {
        return this.bondRegistrationDate;
    }

    public void setBondRegistrationDate(String bondRegistrationDate) {
        this.bondRegistrationDate = bondRegistrationDate;
    }

    public String getCurrentPrincipalValue() {
        return this.currentPrincipalValue;
    }

    public void setCurrentPrincipalValue(String currentPrincipalValue) {
        this.currentPrincipalValue = currentPrincipalValue;
    }

    public String getPrincipalValueEffectiveDate() {
        return this.principalValueEffectiveDate;
    }

    public void setPrincipalValueEffectiveDate(String principalValueEffectiveDate) {
        this.principalValueEffectiveDate = principalValueEffectiveDate;
    }

    public String getFirstInterestPaymentDate() {
        return this.firstInterestPaymentDate;
    }

    public void setFirstInterestPaymentDate(String firstInterestPaymentDate) {
        this.firstInterestPaymentDate = firstInterestPaymentDate;
    }

    public String getCutoffTransferDate() {
        return this.cutoffTransferDate;
    }

    public void setCutoffTransferDate(String cutoffTransferDate) {
        this.cutoffTransferDate = cutoffTransferDate;
    }

}
