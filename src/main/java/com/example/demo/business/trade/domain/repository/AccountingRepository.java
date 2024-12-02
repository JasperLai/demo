package com.example.demo.business.trade.domain.repository;

import com.example.demo.business.trade.domain.entity.Accounting;

public interface AccountingRepository {
    void save(Accounting accounting);
    Accounting findByTxTraceNum(String txTraceNum);
    Accounting findByInitTxTraceNum(String initTxTraceNum);
    void update(Accounting accounting);
} 