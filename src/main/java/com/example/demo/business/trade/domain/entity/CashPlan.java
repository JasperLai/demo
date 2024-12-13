package com.example.demo.business.trade.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.business.trade.domain.valueobject.CashType;
import com.example.demo.business.trade.domain.valueobject.CashPlanStatus;

/**
 * 付息兑付计划实体
 */
public class CashPlan {
    private String tradeAcc;         // 交易账号
    private String bondCode;         // 债券代码
    private String captAcc;          // 资金账号
    private LocalDate workDate;      // 交割日期
    private BigDecimal amount;       // 交易金额
    private CashType cashType;       // 付款类型
    private CashPlanStatus status;   // 计划状态
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

    public CashType getCashType() {
        return cashType;
    }

    public void setCashType(CashType cashType) {
        this.cashType = cashType;
    }

    public CashPlanStatus getStatus() {
        return status;
    }

    public void setStatus(CashPlanStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
} 