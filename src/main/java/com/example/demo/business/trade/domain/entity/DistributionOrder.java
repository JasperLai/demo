package com.example.demo.business.trade.domain.entity;

import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.trade.cllient.TradeConstant;

public class DistributionOrder extends Order {
    
    public DistributionOrder() {
        super();
    }
    
    @Override
    public void validate() {
        // 实现分销订单特定的验证逻辑
    }

    @Override
    public String getOrderType() {
        return TradeType.DISTRIBUTION.getCode();
    }

    @Override
    protected void initializeOrderSpecifics() {
        this.setSummary(TradeType.DISTRIBUTION.getName());
        this.setTxCode(TradeType.DISTRIBUTION.getCode());
        this.setBuySellInd(TradeConstant.DIRECTION_BANK_SELL);
        this.setOrderStatus(TradeConstant.ORDER_STATUS_INIT);
    }
} 