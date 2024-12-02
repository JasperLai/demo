package com.example.demo.business.trade.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.business.trade.domain.entity.Accounting;
import com.example.demo.business.trade.domain.repository.AccountingRepository;
import com.example.demo.business.trade.infrastructure.mapper.AccountingMapper;

@Repository
public class AccountingRepositoryImpl implements AccountingRepository {
    
    @Autowired
    private AccountingMapper accountingMapper;
    
    @Override
    public void save(Accounting accounting) {
        accountingMapper.insert(accounting);
    }
    
    @Override
    public Accounting findByTxTraceNum(String txTraceNum) {
        return accountingMapper.selectByTxTraceNum(txTraceNum);
    }
    
    @Override
    public Accounting findByInitTxTraceNum(String initTxTraceNum) {
        return accountingMapper.selectByInitTxTraceNum(initTxTraceNum);
    }
    
    @Override
    public void update(Accounting accounting) {
        accountingMapper.update(accounting);
    }
} 