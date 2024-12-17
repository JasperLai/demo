package com.example.demo.business.trade.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.business.trade.domain.entity.Order;

@Service
public class OrderProcessorImpl implements OrderProcessor {

    @Override
    public boolean paySingle(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'paySingle'");
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