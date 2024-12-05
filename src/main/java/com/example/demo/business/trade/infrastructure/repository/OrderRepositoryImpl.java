package com.example.demo.business.trade.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.business.trade.domain.entity.Order;
import com.example.demo.business.trade.domain.repository.OrderRepository;
import com.example.demo.business.trade.infrastructure.mapper.OrdersMapper;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    
    @Autowired
    private OrdersMapper ordersMapper;
    
    @Override
    public void save(Order order) {
        ordersMapper.insert(order);
    }
    
    @Override
    public Order findByTxTraceNum(String txTraceNum) {
        return ordersMapper.selectByTxTraceNum(txTraceNum);
    }
    
    @Override
    public List<Order> findByTradeAcc(String tradeAcc) {
        return ordersMapper.selectByTradeAcc(tradeAcc);
    }
    
    @Override
    public List<Order> findByProductId(String productId) {
        return ordersMapper.selectByProductId(productId);
    }
    
    @Override
    public void update(Order order) {
        ordersMapper.update(order);
    }
} 