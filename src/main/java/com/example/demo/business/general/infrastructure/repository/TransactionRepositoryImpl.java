package com.example.demo.business.general.infrastructure.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.business.general.domain.entity.Transaction;
import com.example.demo.business.general.domain.repository.TransactionRepository;
import com.example.demo.business.general.infrastructure.repository.mapper.TransactionMapper;
import com.example.demo.business.general.client.TransStatus;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionMapper transactionMapper;
    
    @Override
    public void save(Transaction transaction) {
        transactionMapper.insert(transaction);
    }
    
    @Override
    public Transaction findById(String transactionId) {
        return transactionMapper.selectById(transactionId);
    }
    
    @Override
    public void updateStatus(String transactionId, TransStatus status) {
        transactionMapper.updateStatus(transactionId, status);
    }
    
    @Override
    public List<Transaction> findByOperatorId(String operatorId) {
        return transactionMapper.selectByOperatorId(operatorId);
    }
} 