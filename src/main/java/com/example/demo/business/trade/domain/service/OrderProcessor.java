package com.example.demo.business.trade.domain.service;

import java.util.List;

import com.example.demo.business.trade.domain.entity.Order;

public interface OrderProcessor {

    boolean paySingle(Order order);

    boolean payBatch(List<Order> orders);

    boolean revert(Order order);
  
} 