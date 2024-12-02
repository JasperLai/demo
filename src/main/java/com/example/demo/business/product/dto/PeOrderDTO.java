package com.example.demo.business.product.dto;

import java.math.BigDecimal;
import java.util.Date;

public class PeOrderDTO {
    private Long id;                     
    private String txTraceNum;           
    private String coreIntTraceNum;      
    private BigDecimal txAnt;            
    private String peServiceName;        
    private String peOrderNum;           
    private String wrtoffStatus;         
    private String wrtoffCond;           
    private Date txDt;                   
    private Date wrtoffDt;               

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