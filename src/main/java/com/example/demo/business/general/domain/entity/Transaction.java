package com.example.demo.business.general.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
        
    /**
     * 交易流水号
     */
    private String txTraceNum;
    
    /**
     * 发起端交易流水号
     */
    private String initTxTraceNum;
    
    /**
     * 渠道编号
     */
    private String channelNo;
    
    /**
     * 交易机构号
     */
    private String txIntOrgNum;
    
    /**
     * 柜员编号
     */
    private String tellerNo;
    
    /**
     * 交易类型编码
     */
    private String tradeType;
    
    /**
     * 交易账号
     */
    private String tradeAcc;
    
    /**
     * 业务日期
     */
    private LocalDate businessDate;
    
    /**
     * 交易发生时间
     */
    private LocalDateTime tradeTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 状态
     */
    private String status;
    
    /**
     * 备注
     */
    private String remark;

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

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getTxIntOrgNum() {
        return txIntOrgNum;
    }

    public void setTxIntOrgNum(String txIntOrgNum) {
        this.txIntOrgNum = txIntOrgNum;
    }

    public String getTellerNo() {
        return tellerNo;
    }

    public void setTellerNo(String tellerNo) {
        this.tellerNo = tellerNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeAcc() {
        return tradeAcc;
    }

    public void setTradeAcc(String tradeAcc) {
        this.tradeAcc = tradeAcc;
    }

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public LocalDateTime getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(LocalDateTime tradeTime) {
        this.tradeTime = tradeTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    // Getters and Setters
    // ... (省略getter/setter代码)
    
} 