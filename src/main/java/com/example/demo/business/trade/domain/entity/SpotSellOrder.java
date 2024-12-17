package com.example.demo.business.trade.domain.entity;

import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.trade.cllient.TradeConstant;
import com.example.demo.business.trade.domain.service.OrderProcessor;

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
        this.setTradeDirection(source.getTradeDirection());
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
        this.setTradeDirection(TradeConstant.DIRECTION_BANK_SELL);
        this.setOrderStatus(TradeConstant.ORDER_STATUS_INIT);
    }

    @Override
    protected boolean doProcess(OrderProcessor processor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doProcess'");
    }

} 