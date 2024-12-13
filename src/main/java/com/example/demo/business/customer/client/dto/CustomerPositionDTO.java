package com.example.demo.business.customer.client.dto;

import java.math.BigDecimal;

public class CustomerPositionDTO {
    private String customerId;        // 客户号
    private String bondCode;          // 债券代码
    private String captAcc;           // 资金账号
    private BigDecimal faceAmount;    // 持仓面额

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getCaptAcc() {
        return captAcc;
    }

    public void setCaptAcc(String captAcc) {
        this.captAcc = captAcc;
    }

    public BigDecimal getFaceAmount() {
        return faceAmount;
    }

    public void setFaceAmount(BigDecimal faceAmount) {
        this.faceAmount = faceAmount;
    }
} 