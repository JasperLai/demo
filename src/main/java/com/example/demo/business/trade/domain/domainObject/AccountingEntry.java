package com.example.demo.business.trade.domain.domainObject;

import java.math.BigDecimal;
import java.util.Date;

public class AccountingEntry {
    private String transNum;
    private String tradeBehavior;
    private int reversalFlag;
    private String reversalTraceNum;
    private Date reversalDate;
    private String originTraceNum;
    private String bondCode;
    private BigDecimal tradeAmt;
    private Date tradeDate;
    private String currency;
    private String tradeOrg;
    private String accountOrg;

    // Getters and Setters

    public String getTransNum() {
        return transNum;
    }

    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

    public String getTradeBehavior() {
        return tradeBehavior;
    }

    public void setTradeBehavior(String tradeBehavior) {
        this.tradeBehavior = tradeBehavior;
    }

    public int getReversalFlag() {
        return reversalFlag;
    }

    public void setReversalFlag(int reversalFlag) {
        this.reversalFlag = reversalFlag;
    }

    public String getReversalTraceNum() {
        return reversalTraceNum;
    }

    public void setReversalTraceNum(String reversalTraceNum) {
        this.reversalTraceNum = reversalTraceNum;
    }

    public Date getReversalDate() {
        return reversalDate;
    }

    public void setReversalDate(Date reversalDate) {
        this.reversalDate = reversalDate;
    }

    public String getOriginTraceNum() {
        return originTraceNum;
    }

    public void setOriginTraceNum(String originTraceNum) {
        this.originTraceNum = originTraceNum;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public BigDecimal getTradeAmt() {
        return tradeAmt;
    }

    public void setTradeAmt(BigDecimal tradeAmt) {
        this.tradeAmt = tradeAmt;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTradeOrg() {
        return tradeOrg;
    }

    public void setTradeOrg(String tradeOrg) {
        this.tradeOrg = tradeOrg;
    }

    public String getAccountOrg() {
        return accountOrg;
    }

    public void setAccountOrg(String accountOrg) {
        this.accountOrg = accountOrg;
    }

    // Additional methods and logic can be added as needed
}
