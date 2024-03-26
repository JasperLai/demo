package com.example.demo.business.trade.domain.domainObject;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import com.example.demo.business.trade.domain.valueObject.OrderType;


public abstract class BondOrder {
    protected String transNum;
    protected String originTraceNum;
    protected String bondCode;
    protected String bpNumber;
    protected BigDecimal tradeAmt;
    protected BigDecimal exPrice;
    protected Date tradeDate;
    protected String tradeOrg;
    protected Currency currency;
    protected int status;

    public abstract void processOrder();
    public abstract void revertOrder();
    public abstract OrderType getOrderType();

    public String getTransNum() {
        return transNum;
    }
    public void setTransNum(String transNum) {
        this.transNum = transNum;
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
    public String getBpNumber() {
        return bpNumber;
    }
    public void setBpNumber(String bpNumber) {
        this.bpNumber = bpNumber;
    }
    public BigDecimal getTradeAmt() {
        return tradeAmt;
    }
    public void setTradeAmt(BigDecimal tradeAmt) {
        this.tradeAmt = tradeAmt;
    }
    public BigDecimal getExPrice() {
        return exPrice;
    }
    public void setExPrice(BigDecimal exPrice) {
        this.exPrice = exPrice;
    }
    public Date getTradeDate() {
        return tradeDate;
    }
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
    public String getTradeOrg() {
        return tradeOrg;
    }
    public void setTradeOrg(String tradeOrg) {
        this.tradeOrg = tradeOrg;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    // Getters and setters for all attributes would be here
    // ...

    // Concrete methods can also be defined that are shared across all subclasses
}

