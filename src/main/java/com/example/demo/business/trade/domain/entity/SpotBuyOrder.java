package com.example.demo.business.trade.domain.entity;

import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.trade.cllient.TradeConstant;

public class SpotBuyOrder extends Order {
    
    public SpotBuyOrder() {
        super();
    }
    
    @Override
    public void validate() {
        // 实现现券买入订单特定的验证逻辑
    }

    @Override
    public String getOrderType() {
        return TradeType.BANK_BUY.getCode();
    }

    @Override
    protected void initializeOrderSpecifics() {
        this.setSummary(TradeType.BANK_BUY.getName());
        this.setTxCode(TradeType.BANK_BUY.getCode());
        this.setBuySellInd(TradeConstant.DIRECTION_BANK_BUY);
        this.setOrderStatus(TradeConstant.ORDER_STATUS_INIT);
    }
} 