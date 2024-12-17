package com.example.demo.business.trade.domain.facade;

import com.example.demo.business.trade.domain.entity.Order;
import com.example.demo.business.trade.domain.entity.PeOrder;

public interface PaymentFacade {
    
    public PeOrder payWaitForProcess(Order order, String tradeBehavior, String fdmProductCode);

}
