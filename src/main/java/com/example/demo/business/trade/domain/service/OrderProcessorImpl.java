package com.example.demo.business.trade.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.trade.domain.entity.AccountingEntry;
import com.example.demo.business.trade.domain.entity.Order;
import com.example.demo.business.trade.domain.entity.PeOrder;
import com.example.demo.business.trade.domain.facade.PaymentFacade;
import com.example.demo.business.trade.domain.repository.AccountingRepository;
import com.example.demo.business.trade.domain.repository.PeOrderRepository;

@Service
public class OrderProcessorImpl implements OrderProcessor {

    @Autowired
    private PaymentFacade paymentFacade;
    
    @Autowired
    private AccountingRepository accountingRepository;
    
    @Autowired
    private PeOrderRepository peOrderRepository;

    @Override
    public boolean paySingle(Order order) {
        // 1. 创建账务对象
        AccountingEntry accountingEntry = new AccountingEntry(order);
        
        // 2. 调用支付服务
        PeOrder peOrder = paymentFacade.payWaitForProcess(order, accountingEntry.getTxBehav(), accountingEntry.getFdmProductCode());
        if (peOrder == null) {
            return false;
        }
        
        // 3. 保存账务对象
        accountingRepository.save(accountingEntry);
        
        // 4. 保存PE订单
        peOrderRepository.save(peOrder);
        
        return true;
    }

    @Override
    public boolean payBatch(List<Order> orders) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payBatch'");
    }

    @Override
    public boolean revert(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'revert'");
    }

   
} 