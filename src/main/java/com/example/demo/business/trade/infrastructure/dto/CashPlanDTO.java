package com.example.demo.business.trade.infrastructure.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CashPlanDTO {
    private String tradeAcc;         // 交易账号
    private String bondCode;         // 债券代码
    private String captAcc;          // 资金账号
    private LocalDate workDate;      // 交割日期
    private BigDecimal amount;       // 交易金额
    private String cashType;         // 付款类型
    private String status;           // 计划状态
    private String remark;           // 备注

    // Getters and Setters
    public String getTradeAcc() {
        return tradeAcc;
    }

    public void setTradeAcc(String tradeAcc) {
        this.tradeAcc = tradeAcc;
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

    public LocalDate getWorkDate() {
        return workDate;
    }

    public void setWorkDate(LocalDate workDate) {
        this.workDate = workDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCashType() {
        return cashType;
    }

    public void setCashType(String cashType) {
        this.cashType = cashType;
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
} 