package com.example.demo.business.trade.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PeOrderEntity {
    private Long id;                     // 自增主键
    private String txTraceNum;           // 交易流水号
    private String coreIntTraceNum;      // 核心内部流水号
    private BigDecimal txAnt;            // 交易金额
    private String peServiceName;        // PE接口名
    private String peOrderNum;           // 订单号
    private String wrtoffStatus;         // 核销状态
    private String wrtoffCond;           // 核销条件
    private Date txDt;                   // 交易日期
    private Date wrtoffDt;               // 核销日期

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

    public String getCoreIntTraceNum() {
        return coreIntTraceNum;
    }

    public void setCoreIntTraceNum(String coreIntTraceNum) {
        this.coreIntTraceNum = coreIntTraceNum;
    }

    public BigDecimal getTxAnt() {
        return txAnt;
    }

    public void setTxAnt(BigDecimal txAnt) {
        this.txAnt = txAnt;
    }

    public String getPeServiceName() {
        return peServiceName;
    }

    public void setPeServiceName(String peServiceName) {
        this.peServiceName = peServiceName;
    }

    public String getPeOrderNum() {
        return peOrderNum;
    }

    public void setPeOrderNum(String peOrderNum) {
        this.peOrderNum = peOrderNum;
    }

    public String getWrtoffStatus() {
        return wrtoffStatus;
    }

    public void setWrtoffStatus(String wrtoffStatus) {
        this.wrtoffStatus = wrtoffStatus;
    }

    public String getWrtoffCond() {
        return wrtoffCond;
    }

    public void setWrtoffCond(String wrtoffCond) {
        this.wrtoffCond = wrtoffCond;
    }

    public Date getTxDt() {
        return txDt;
    }

    public void setTxDt(Date txDt) {
        this.txDt = txDt;
    }

    public Date getWrtoffDt() {
        return wrtoffDt;
    }

    public void setWrtoffDt(Date wrtoffDt) {
        this.wrtoffDt = wrtoffDt;
    }
} 