package com.example.demo.business.trade.domain.repository;

import com.example.demo.business.trade.domain.entity.AccountingEntry;

public interface AccountingRepository {
    void save(AccountingEntry accounting);
    AccountingEntry findByTxTraceNum(String txTraceNum);
    AccountingEntry findByInitTxTraceNum(String initTxTraceNum);
    void update(AccountingEntry accounting);
} 