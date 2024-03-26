package com.example.demo.business.trade.domain.domainObject.Order;

import com.example.demo.business.trade.domain.domainObject.BondOrder;
import com.example.demo.business.trade.domain.valueObject.OrderType;

public class ClientBuyOrder extends BondOrder{

    @Override
    public void processOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processOrder'");
    }

    @Override
    public void revertOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'revertOrder'");
    }

    @Override
    public OrderType getOrderType() {
        return OrderType.CLIENT_BUY_ORDER;
    }

}
