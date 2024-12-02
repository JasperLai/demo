package com.example.demo.business.trade.app.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrdersDTO {
    private Long id;                     
    private String txTraceNum;           
    private String initTxTraceNum;       
    private String txCode;               
    private String bondSn;               
    private String bondCode;             
    private String tradeAcc;             
    private String captNum;              
    private String captAcctType;         
    private BigDecimal txMnt;            
    private String txQuantity;           
    private String dealPrice;            
    private Date txDt;                   
    private Date txIn;                   
    private String txIntOrgNum;          
    private String orderStatus;          
    private String summary;              

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTxTraceNum() {
        return txTraceNum;
    }

    public void setTxTraceNum(String txTraceNum) {
        this.txTraceNum = txTraceNum;
    }

    public String getInitTxTraceNum() {
        return initTxTraceNum;
    }

    public void setInitTxTraceNum(String initTxTraceNum) {
        this.initTxTraceNum = initTxTraceNum;
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getBondSn() {
        return bondSn;
    }

    public void setBondSn(String bondSn) {
        this.bondSn = bondSn;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getTradeAcc() {
        return tradeAcc;
    }

    public void setTradeAcc(String tradeAcc) {
        this.tradeAcc = tradeAcc;
    }

    public String getCaptNum() {
        return captNum;
    }

    public void setCaptNum(String captNum) {
        this.captNum = captNum;
    }

    public String getCaptAcctType() {
        return captAcctType;
    }

    public void setCaptAcctType(String captAcctType) {
        this.captAcctType = captAcctType;
    }

    public BigDecimal getTxMnt() {
        return txMnt;
    }

    public void setTxMnt(BigDecimal txMnt) {
        this.txMnt = txMnt;
    }

    public String getTxQuantity() {
        return txQuantity;
    }

    public void setTxQuantity(String txQuantity) {
        this.txQuantity = txQuantity;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Date getTxDt() {
        return txDt;
    }

    public void setTxDt(Date txDt) {
        this.txDt = txDt;
    }

    public Date getTxIn() {
        return txIn;
    }

    public void setTxIn(Date txIn) {
        this.txIn = txIn;
    }

    public String getTxIntOrgNum() {
        return txIntOrgNum;
    }

    public void setTxIntOrgNum(String txIntOrgNum) {
        this.txIntOrgNum = txIntOrgNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
} 