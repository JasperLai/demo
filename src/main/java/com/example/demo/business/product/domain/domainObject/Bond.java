package com.example.demo.business.product.domain.domainObject;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.product.domain.valueObject.CustodyOrg;
import com.example.demo.business.product.domain.valueObject.InterestBase;
import com.example.demo.business.product.domain.valueObject.InterestType;

public class Bond {

    private String bondCode;

    private String fullName;

    private String shortName;

    private BondVariety variety;

    private int bondTerm; //3 years, 5 years , etc

    private BigDecimal coupon; // % as unit

    private String currency;

    private String issuer;

    private BigDecimal issuePrice;

    private int transferPauseDayBeforeCash; //付息兑付日转托管业务停止天数， 工作日

    private Date matureDate; 

    private Date issueEndDate;  

    private Date startTradeDate;

    private Date startIntDate;

    private Date issueStartDate;

    private InterestBase interestBase;

    private InterestType interestType;

    private int parValue;

    private CustodyOrg custodyOrg;

    public String getBondCode() {
        return this.bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BondVariety getVariety() {
        return this.variety;
    }

    public void setVariety(BondVariety variety) {
        this.variety = variety;
    }

    public int getBondTerm() {
        return this.bondTerm;
    }

    public void setBondTerm(int bondTerm) {
        this.bondTerm = bondTerm;
    }

    public BigDecimal getCoupon() {
        return this.coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public BigDecimal getIssuePrice() {
        return this.issuePrice;
    }

    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }

    public int getTransferPauseDayBeforeCash() {
        return this.transferPauseDayBeforeCash;
    }

    public void setTransferPauseDayBeforeCash(int transferPauseDayBeforeCash) {
        this.transferPauseDayBeforeCash = transferPauseDayBeforeCash;
    }

    public Date getMatureDate() {
        return this.matureDate;
    }

    public void setMatureDate(Date matureDate) {
        this.matureDate = matureDate;
    }

    public Date getIssueEndDate() {
        return this.issueEndDate;
    }

    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public Date getStartTradeDate() {
        return this.startTradeDate;
    }

    public void setStartTradeDate(Date startTradeDate) {
        this.startTradeDate = startTradeDate;
    }

    public Date getStartIntDate() {
        return this.startIntDate;
    }

    public void setStartIntDate(Date startIntDate) {
        this.startIntDate = startIntDate;
    }

    public Date getIssueStartDate() {
        return this.issueStartDate;
    }

    public void setIssueStartDate(Date issueStartDate) {
        this.issueStartDate = issueStartDate;
    }

    public InterestBase getInterestBase() {
        return this.interestBase;
    }

    public void setInterestBase(InterestBase interestBase) {
        this.interestBase = interestBase;
    }

    public InterestType getInterestType() {
        return this.interestType;
    }

    public void setInterestType(InterestType interestType) {
        this.interestType = interestType;
    }

    public int getParValue() {
        return this.parValue;
    }

    public void setParValue(int parValue) {
        this.parValue = parValue;
    }

    public CustodyOrg getCustodyOrg() {
        return this.custodyOrg;
    }

    public void setCustodyOrg(CustodyOrg custodyOrg) {
        this.custodyOrg = custodyOrg;
    }

    /**
     * TODO 获取下一付息日
     * @return
     */
    public Date getNextDayForPayingInterest(){
        return null;
    }

    /**
     * TODO 计算当前付息周期的应计利息（以面额为单位）
     * @return 2 位小叔
     */
    public BigDecimal calculateCurrentInt(){
        return null;
    }

    /**
     *  TODO 判断当天是否可以进行转托管交易
     */
     public boolean canTransferToday(){
        return false;
    }

}

   