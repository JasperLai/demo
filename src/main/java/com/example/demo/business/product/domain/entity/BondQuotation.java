package com.example.demo.business.product.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class BondQuotation {

    private String bondCode;
    private BigDecimal bankBuyNetPrice;
    private BigDecimal bankSellNetPrice;
    private BigDecimal accruedInterest;
    private int quotationType; //1 手工 0 自动
    private Date quotationDate ;//报价日期 需要使用canlendar 类


    public String getBondCode() {
        return this.bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public BigDecimal getBankBuyNetPrice() {
        return this.bankBuyNetPrice;
    }

    public void setBankBuyNetPrice(BigDecimal bankBuyNetPrice) {
        this.bankBuyNetPrice = bankBuyNetPrice;
    }

    public BigDecimal getBankSellNetPrice() {
        return this.bankSellNetPrice;
    }

    public void setBankSellNetPrice(BigDecimal bankSellNetPrice) {
        this.bankSellNetPrice = bankSellNetPrice;
    }

    public BigDecimal getAccruedInterest() {
        return this.accruedInterest;
    }

    public void setAccruedInterest(BigDecimal accruedInterest) {
        this.accruedInterest = accruedInterest;
    }

    public int getQuotationType() {
        return this.quotationType;
    }

    public void setQuotationType(int quotationType) {
        this.quotationType = quotationType;
    }

    public Date getQuotationDate() {
        return this.quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    public BigDecimal getBankBuyFullPrice(){
        
        return bankBuyNetPrice.add(accruedInterest);
    }

    public BigDecimal getBankSellFullPrice(){
        
        return bankSellNetPrice.add(accruedInterest);
    }

}
