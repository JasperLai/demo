package com.example.demo.business.trade.app.dto;

import java.math.BigDecimal;
import java.util.Date;

public class AccountingDTO {
    private String txTraceNum;           
    private String initTxTraceNum;       
    private String fdmProductCode;       
    private String txBehav;              
    private String txIntOrgNum;          
    private String accOrg;               
    private Date txDt;                   
    private Date txTranEntryDt;          
    private Date txTm;                   
    private String txCurrCd;             
    private String txTradeCode;          
    private BigDecimal txAmt;            
    private String txAccModule;          
    private String strkBalTraceNum;      
    private String wrtoffInd;            
    private Date revDt;                  

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

    public String getFdmProductCode() {
        return fdmProductCode;
    }

    public void setFdmProductCode(String fdmProductCode) {
        this.fdmProductCode = fdmProductCode;
    }

    public String getTxBehav() {
        return txBehav;
    }

    public void setTxBehav(String txBehav) {
        this.txBehav = txBehav;
    }

    public String getTxIntOrgNum() {
        return txIntOrgNum;
    }

    public void setTxIntOrgNum(String txIntOrgNum) {
        this.txIntOrgNum = txIntOrgNum;
    }

    public String getAccOrg() {
        return accOrg;
    }

    public void setAccOrg(String accOrg) {
        this.accOrg = accOrg;
    }

    public Date getTxDt() {
        return txDt;
    }

    public void setTxDt(Date txDt) {
        this.txDt = txDt;
    }

    public Date getTxTranEntryDt() {
        return txTranEntryDt;
    }

    public void setTxTranEntryDt(Date txTranEntryDt) {
        this.txTranEntryDt = txTranEntryDt;
    }

    public Date getTxTm() {
        return txTm;
    }

    public void setTxTm(Date txTm) {
        this.txTm = txTm;
    }

    public String getTxCurrCd() {
        return txCurrCd;
    }

    public void setTxCurrCd(String txCurrCd) {
        this.txCurrCd = txCurrCd;
    }

    public String getTxTradeCode() {
        return txTradeCode;
    }

    public void setTxTradeCode(String txTradeCode) {
        this.txTradeCode = txTradeCode;
    }

    public BigDecimal getTxAmt() {
        return txAmt;
    }

    public void setTxAmt(BigDecimal txAmt) {
        this.txAmt = txAmt;
    }

    public String getTxAccModule() {
        return txAccModule;
    }

    public void setTxAccModule(String txAccModule) {
        this.txAccModule = txAccModule;
    }

    public String getStrkBalTraceNum() {
        return strkBalTraceNum;
    }

    public void setStrkBalTraceNum(String strkBalTraceNum) {
        this.strkBalTraceNum = strkBalTraceNum;
    }

    public String getWrtoffInd() {
        return wrtoffInd;
    }

    public void setWrtoffInd(String wrtoffInd) {
        this.wrtoffInd = wrtoffInd;
    }

    public Date getRevDt() {
        return revDt;
    }

    public void setRevDt(Date revDt) {
        this.revDt = revDt;
    }
} 