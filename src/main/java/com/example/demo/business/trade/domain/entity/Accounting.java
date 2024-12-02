package com.example.demo.business.trade.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Accounting {
    private Long id;                     // 自增主键
    private String txTraceNum;           // 交易流水号
    private String initTxTraceNum;       // 发起端交易流水号
    private String fdmProductCode;       // FDM产品编码
    private String txBehav;              // 交易行为
    private String txIntOrgNum;          // 交易机构号
    private String accOrg;               // 账务机构号
    private Date txDt;                   // 交易日期
    private Date txTranEntryDt;          // 交易过账日期
    private Date txTm;                   // 交易时间
    private String txCurrCd;             // 交易币种
    private String txTradeCode;          // 交易编码
    private BigDecimal txAmt;            // 交易金额
    private String txAccModule;          // 过账模块
    private String strkBalTraceNum;      // 被冲抹账流水号
    private String wrtoffInd;            // 冲抹标志
    private Date revDt;                  // 冲抹日期

    // getters and setters
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