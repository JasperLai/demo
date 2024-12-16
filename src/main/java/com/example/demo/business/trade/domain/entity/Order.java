package com.example.demo.business.trade.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String txTraceNum;           // 交易流水号
    private String initTxTraceNum;       // 发起端交易流水号
    private String txCode;               // 交易编码
    private String productId;            // 产品代码
    private String tradeAcc;             // 交易账号
    private String captNum;              // 资金账号
    private String captAcctType;         // 支付账号类型
    private BigDecimal txMnt;            // 交易金额
    private String txQuantity;           // 交易份额
    private String dealPrice;            // 成交价格
    private Date txDt;                   // 交易日期
    private Date txIn;                   // 交易时间
    private String txIntOrgNum;          // 交易机构号
    private String orderStatus;          // 订单状态
    private String summary;              // 摘要
    private String buySellInd;           // 交易方向：1-银行买入 2-银行卖出

    // 为了支持异常处理场景，添加一些便捷方法
    public String getCustomerId() {
        return this.tradeAcc;  // 交易账号就是客户ID
    }

    public BigDecimal getAmount() {
        return this.txMnt;
    }

    public String getStatus() {
        return this.orderStatus;
    }

    // 原有的 getter/setter 方法
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

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTradeAcc() {
        return tradeAcc;
    }

    public void setTradeAcc(String tradeAcc) {
        this.tradeAcc = tradeAcc;
    }

    public String getCaptNum() {
        return captNum;
    }

    public void setCaptNum(String captNum) {
        this.captNum = captNum;
    }

    public String getCaptAcctType() {
        return captAcctType;
    }

    public void setCaptAcctType(String captAcctType) {
        this.captAcctType = captAcctType;
    }

    public BigDecimal getTxMnt() {
        return txMnt;
    }

    public void setTxMnt(BigDecimal txMnt) {
        this.txMnt = txMnt;
    }

    public String getTxQuantity() {
        return txQuantity;
    }

    public void setTxQuantity(String txQuantity) {
        this.txQuantity = txQuantity;
    }

    public String getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(String dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Date getTxDt() {
        return txDt;
    }

    public void setTxDt(Date txDt) {
        this.txDt = txDt;
    }

    public Date getTxIn() {
        return txIn;
    }

    public void setTxIn(Date txIn) {
        this.txIn = txIn;
    }

    public String getTxIntOrgNum() {
        return txIntOrgNum;
    }

    public void setTxIntOrgNum(String txIntOrgNum) {
        this.txIntOrgNum = txIntOrgNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBuySellInd() {
        return buySellInd;
    }

    public void setBuySellInd(String buySellInd) {
        this.buySellInd = buySellInd;
    }
} 