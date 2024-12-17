package com.example.demo.business.trade.domain.entity;

import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.trade.cllient.TradeConstant;

public class SpotSellOrder extends Order {
    
    public SpotSellOrder() {
        super();
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