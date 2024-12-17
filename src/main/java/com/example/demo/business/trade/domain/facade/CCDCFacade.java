package com.example.demo.business.trade.domain.facade;

import com.example.demo.business.trade.domain.entity.Order;

public interface CCDCFacade {
    public void distributeReport(Order order);

    public void spotBuyReport(Order order);

    public void spotSellReport(Order order);
}
