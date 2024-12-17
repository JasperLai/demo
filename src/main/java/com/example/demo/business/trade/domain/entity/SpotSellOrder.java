package com.example.demo.business.trade.domain.entity;

import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.trade.cllient.TradeConstant;

public class SpotSellOrder extends Order {
    
    public SpotSellOrder() {
        super();
    }
    
    public SpotSellOrder(Order source) {
        super();
        this.setTxTraceNum(source.getTxTraceNum());
        this.setInitTxTraceNum(source.getInitTxTraceNum());
        this.setTxCode(source.getTxCode());
        this.setProductId(source.getProductId());
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
        this.setBuySellInd(source.getBuySellInd());
    }
    
    @Override
    public void validate() {
        // 实现现券卖出订单特定的验证逻辑
    }

    @Override
    public String getOrderType() {
        return TradeType.BANK_SELL.getCode();
    }

    @Override
    protected void initializeOrderSpecifics() {
        this.setSummary(TradeType.BANK_SELL.getName());
        this.setTxCode(TradeType.BANK_SELL.getCode());
        this.setBuySellInd(TradeConstant.DIRECTION_BANK_SELL);
        this.setOrderStatus(TradeConstant.ORDER_STATUS_INIT);
    }
} 