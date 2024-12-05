package com.example.demo.business.general.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.business.general.domain.entity.Transaction;

public class TransactionDTO {
    
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
     * 状态
     */
    private String status;
    
    /**
     * 备注
     */
    private String remark;

    // Getters and Setters
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

    /**
     * 将 Transaction 实体转换为 DTO
     */
    public static TransactionDTO fromEntity(Transaction transaction) {
        if (transaction == null) {
            return null;
        }
        
        TransactionDTO dto = new TransactionDTO();
        dto.setTxTraceNum(transaction.getTxTraceNum());
        dto.setInitTxTraceNum(transaction.getInitTxTraceNum());
        dto.setChannelNo(transaction.getChannelNo());
        dto.setTxIntOrgNum(transaction.getTxIntOrgNum());
        dto.setTellerNo(transaction.getTellerNo());
        dto.setTradeType(transaction.getTradeType());
        dto.setTradeAcc(transaction.getTradeAcc());
        dto.setBusinessDate(transaction.getBusinessDate());
        dto.setTradeTime(transaction.getTradeTime());
        dto.setStatus(transaction.getStatus());
        dto.setRemark(transaction.getRemark());
        return dto;
    }

    /**
     * 将 DTO 转换为 Transaction 实体
     */
    public Transaction toEntity() {
        Transaction entity = new Transaction();
        entity.setTxTraceNum(this.txTraceNum);
        entity.setInitTxTraceNum(this.initTxTraceNum);
        entity.setChannelNo(this.channelNo);
        entity.setTxIntOrgNum(this.txIntOrgNum);
        entity.setTellerNo(this.tellerNo);
        entity.setTradeType(this.tradeType);
        entity.setTradeAcc(this.tradeAcc);
        entity.setBusinessDate(this.businessDate);
        entity.setTradeTime(this.tradeTime);
        entity.setStatus(this.status);
        entity.setRemark(this.remark);
        return entity;
    }
}
