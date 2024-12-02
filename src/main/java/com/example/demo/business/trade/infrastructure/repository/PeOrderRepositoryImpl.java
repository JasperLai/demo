package com.example.demo.business.trade.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.business.trade.domain.entity.PeOrder;
import com.example.demo.business.trade.domain.repository.PeOrderRepository;
import com.example.demo.business.trade.infrastructure.mapper.PeOrderMapper;

@Repository
public class PeOrderRepositoryImpl implements PeOrderRepository {
    
    @Autowired
    private PeOrderMapper peOrderMapper;
    
    @Override
    public void save(PeOrder peOrder) {
        peOrderMapper.insert(peOrder);
    }
    
    @Override
    public PeOrder findByTxTraceNum(String txTraceNum) {
        return peOrderMapper.selectByTxTraceNum(txTraceNum);
    }
    
    @Override
    public PeOrder findByPeOrderNum(String peOrderNum) {
        return peOrderMapper.selectByPeOrderNum(peOrderNum);
    }
    
    @Override
    public void update(PeOrder peOrder) {
        peOrderMapper.update(peOrder);
    }
} 