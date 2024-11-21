package com.example.demo.business.general.app.dto;

import java.util.Date;
import com.example.demo.business.general.domain.entity.Transaction;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;

public class TransactionDTO {
    private String txTraceNum;
    private String initTxTraceNum;
    private String channelNo;
    private String txIntOrgNum;
    private String tellerNo;
    private String tradeType;
    private String tradeAcc;
    private String businessDate;
    private Date tradeTime;
    private Date updateTime;
    private String status;
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

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
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

    // Static factory method to create DTO from entity
    public static TransactionDTO fromEntity(Transaction entity) {
        if (entity == null) {
            return null;
        }
        
        TransactionDTO dto = new TransactionDTO();
        dto.setTxTraceNum(entity.getTxTraceNum());
        dto.setInitTxTraceNum(entity.getInitTxTraceNum());
        dto.setChannelNo(entity.getChannelNo());
        dto.setTxIntOrgNum(entity.getTxIntOrgNum());
        dto.setTellerNo(entity.getTellerNo());
        dto.setTradeType(entity.getTradeType() != null ? entity.getTradeType().name() : null);
        dto.setTradeAcc(entity.getTradeAcc());
        dto.setBusinessDate(entity.getBusinessDate());
        dto.setTradeTime(entity.getTradeTime());
        dto.setUpdateTime(entity.getUpdateTime());
        dto.setStatus(entity.getStatus() != null ? entity.getStatus().name() : null);
        dto.setRemark(entity.getRemark());
        return dto;
    }

    // Convert DTO to entity
    public Transaction toEntity() {
        Transaction entity = new Transaction();
        entity.setTxTraceNum(this.txTraceNum);
        entity.setInitTxTraceNum(this.initTxTraceNum);
        entity.setChannelNo(this.channelNo);
        entity.setTxIntOrgNum(this.txIntOrgNum);
        entity.setTellerNo(this.tellerNo);
        entity.setTradeType(this.tradeType != null ? TradeType.valueOf(this.tradeType) : null);
        entity.setTradeAcc(this.tradeAcc);
        entity.setBusinessDate(this.businessDate);
        entity.setTradeTime(this.tradeTime);
        entity.setUpdateTime(this.updateTime);
        entity.setStatus(this.status != null ? TransStatus.valueOf(this.status) : null);
        entity.setRemark(this.remark);
        return entity;
    }
}
