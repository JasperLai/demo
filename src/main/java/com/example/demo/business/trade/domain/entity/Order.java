package com.example.demo.business.trade.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.business.trade.cllient.TradeConstant;
import com.example.demo.business.trade.domain.service.OrderProcessor;

public abstract class Order {
    private String txTraceNum;           // 交易流水号
    private String initTxTraceNum;       // 发起端交易流水号
    private String txCode;               // 交易编码
    private String productId;            // 产品代码
    private String bondCode;             // 债券代码
    private String tradeAcc;             // 交易账号
    private String captNum;              // 资金账号
    private String captAcctType;         // 支付账号类型
    private BigDecimal txMnt;            // 交易金额
    private Long txQuantity;           // 交易份额
    private BigDecimal dealPrice;            // 成交价格
    private Date txDt;                   // 交易日期
    private Date txIn;                   // 交易时间
    private String txIntOrgNum;          // 交易机构号
    private String orderStatus;          // 订单状态
    private String summary;              // 摘要
    private String tradeDirection;           // 交易方向：1-银行买入 2-银行卖出

    protected Order() {
        initializeOrderSpecifics();
    }

    // 抽象方法，让子类实现订单特定的业务逻辑
    public abstract void validate();
    public abstract String getOrderType();
    
    // 新增抽象方法，强制子类实现订单特定的初始化逻辑
    protected abstract void initializeOrderSpecifics();
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

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
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

    public Long getTxQuantity() {
        return txQuantity;
    }

    public void setTxQuantity(Long txQuantity) {
        this.txQuantity = txQuantity;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
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

    public String getTradeDirection() {
        return tradeDirection;
    }

    public void setTradeDirection(String buySellInd) {
        this.tradeDirection = buySellInd;
    }

    protected void copyFrom(Order source) {
        this.setTxTraceNum(source.getTxTraceNum());
        this.setInitTxTraceNum(source.getInitTxTraceNum());
        this.setTxCode(source.getTxCode());
        this.setProductId(source.getProductId());
        this.setBondCode(source.getBondCode());
        this.setTradeAcc(source.getTradeAcc());
        this.setCaptNum(source.getCaptNum());
        this.setCaptAcctType(source.getCaptAcctType());
        this.setTxMnt(source.getTxMnt());
        this.setTxQuantity(source.getTxQuantity());
        this.setDealPrice(source.getDealPrice());
        this.setTxDt(source.getTxDt());
        this.setTxIn(source.getTxIn());
        this.setTxIntOrgNum(source.getTxIntOrgNum());
        this.setOrderStatus(source.getOrderStatus());
        this.setSummary(source.getSummary());
        this.setTradeDirection(source.getTradeDirection());
    }

    // 添加抽象的处理方法
    public void process(OrderProcessor processor) {
        preProcess();
        boolean result = doProcess(processor);
        postProcess(result);
    }
    
    // 改为protected，让子类实现具体处理逻辑
    protected abstract boolean doProcess(OrderProcessor processor);
    
    // 可以添加一些通用的处理逻辑
    protected void preProcess() {
        validate();  // 处理前先验证
        this.orderStatus = TradeConstant.ORDER_STATUS_WAITING_PAY;
    }
    
    protected void postProcess(boolean result) {
        // 通用的后处理逻辑
        if (result) {
            this.orderStatus = TradeConstant.ORDER_STATUS_FINISH;
        } else {
            this.orderStatus = TradeConstant.ORDER_STATUS_FAIL;
        }
    }
} 