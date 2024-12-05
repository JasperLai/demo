package com.example.demo.business.general.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.lang.NonNull;

public class TransactionVO {
    
    /**
     * 系统流水号
     */
    private String transactionNo;
    
    /**
     * 渠道流水号
     */
    @NonNull
    private String originalNo;
    
    /**
     * 渠道编号
     */
    @NonNull
    private String channelNo;
    
    /**
     * 交易机构号
     */
    @NonNull
    private String organizationNo;
    
    /**
     * 交易柜员号
     */
    @NonNull
    private String tellerNo;
    
    /**
     * 交易类型
     */
    @NonNull
    private String tradeType;
    
    /**
     * 交易账号
     */
    @NonNull
    private String tradeAccount;
    
    /**
     * 业务日期
     */
    @NonNull
    private LocalDate businessDate;
    
    /**
     * 交易时间
     */
    @NonNull
    private LocalDateTime tradeTime;
    
    /**
     * 备注说明
     */
    private String remark;

    // Getters and Setters
    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getOriginalNo() {
        return originalNo;
    }

    public void setOriginalNo(String originalNo) {
        this.originalNo = originalNo;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getOrganizationNo() {
        return organizationNo;
    }

    public void setOrganizationNo(String organizationNo) {
        this.organizationNo = organizationNo;
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

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
