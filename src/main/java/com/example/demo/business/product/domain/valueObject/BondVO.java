package com.example.demo.business.product.domain.valueObject;

public class BondVO {
    /**债券基本属性 */
    private String bondCode;
    private String bondName;
    private String bondShortName;
    private String bondVariety;
    private String bondTerm;
    private String coupon;
    private String currencyCode;
    private String issuer;
    private String parValue;

    /**债券日期属性 */
    private String issuePrice;
    private String matureDate;
    private String issueDeadline;
    private String listingDate;
    private String accrualDate;
    private String issueDate;
    /**债券计息属性 */
    private String accrualBase;  //计息基准 360/360 .eg
    private String accrualMethod; //计息方式 
    private String accrualPeriod; //计息周期

    /**债券交易属性 */
    private String custodyOrg;  //托管机构
    private String transferPauseDayBeforeCash; 


    // Getter 和 Setter 方法
    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getBondShortName() {
        return bondShortName;
    }

    public void setBondShortName(String bondShortName) {
        this.bondShortName = bondShortName;
    }

    public String getBondVariety() {
        return bondVariety;
    }

    public void setBondVariety(String bondVariety) {
        this.bondVariety = bondVariety;
    }

    public String getBondTerm() {
        return bondTerm;
    }

    public void setBondTerm(String bondIssueTerm) {
        this.bondTerm = bondIssueTerm;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(String issuePrice) {
        this.issuePrice = issuePrice;
    }

    public String getTransferPauseDayBeforeCash() {
        return transferPauseDayBeforeCash;
    }

    public void setTransferPauseDayBeforeCash(String transferPauseDayBeforeCash) {
        this.transferPauseDayBeforeCash = transferPauseDayBeforeCash;
    }

    public String getMatureDate() {
        return matureDate;
    }

    public void setMatureDate(String matureDate) {
        this.matureDate = matureDate;
    }

    public String getIssueDeadline() {
        return issueDeadline;
    }

    public void setIssueDeadline(String endSellDate) {
        this.issueDeadline = endSellDate;
    }

    public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String startTradeDate) {
        this.listingDate = startTradeDate;
    }

    public String getAccrualDate() {
        return accrualDate;
    }

    public void setAccrualDate(String startIntDate) {
        this.accrualDate = startIntDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueStartDate) {
        this.issueDate = issueStartDate;
    }

    public String getAccrualBase() {
        return accrualBase;
    }

    public void setAccrualBase(String interestBase) {
        this.accrualBase = interestBase;
    }

    public String getAccrualMethod() {
        return accrualMethod;
    }

    public void setAccrualMethod(String accrualMethod) {
        this.accrualMethod = accrualMethod;
    }

    public String getAccrualPeriod() {
        return accrualPeriod;
    }

    public void setAccrualPeriod(String interestPeriod) {
        this.accrualPeriod = interestPeriod;
    }

    public String getParValue() {
        return parValue;
    }

    public void setParValue(String parValue) {
        this.parValue = parValue;
    }

    public String getCustodyOrg() {
        return custodyOrg;
    }

    public void setCustodyOrg(String custodyOrg) {
        this.custodyOrg = custodyOrg;
    }
}

