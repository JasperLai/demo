package com.example.demo.business.general.domain.repository;

import com.example.demo.business.general.domain.entity.Transaction;


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
    void updateStatus(Transaction transaction);
    

} 