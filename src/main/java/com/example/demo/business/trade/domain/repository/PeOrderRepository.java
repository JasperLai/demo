package com.example.demo.business.trade.domain.repository;

import com.example.demo.business.trade.domain.entity.PeOrder;

public interface PeOrderRepository {
    void save(PeOrder peOrder);
    PeOrder findByTxTraceNum(String txTraceNum);
    PeOrder findByPeOrderNum(String peOrderNum);
    void update(PeOrder peOrder);
} 