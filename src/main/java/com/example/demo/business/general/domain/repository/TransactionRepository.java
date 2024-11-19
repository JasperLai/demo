package com.example.demo.business.general.domain.repository;

import com.example.demo.business.general.domain.entity.Transaction;

import java.util.List;

import com.example.demo.business.general.client.TransStatus;

public interface TransactionRepository {
    
    /**
     * 保存交易流水
     */
    void save(Transaction transaction);
    
    /**
     * 根据流水号查询交易
     */
    Transaction findById(String transactionId);
    
    /**
     * 更新交易状态
     */
    void updateStatus(String transactionId, TransStatus status);
    
    /**
     * 根据操作员ID查询交易列表
     */
    List<Transaction> findByOperatorId(String operatorId);
} 