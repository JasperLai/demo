package com.example.demo.business.trade.domain.repository;

import com.example.demo.business.trade.domain.entity.Order;
import java.util.List;

public interface OrderRepository {
    void save(Order order);
    Order findByTxTraceNum(String txTraceNum);
    List<Order> findByTradeAcc(String tradeAcc);
    List<Order> findByBondCode(String bondCode);
    void update(Order order);
} 