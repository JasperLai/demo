package com.example.demo.business.general.infrastructure.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.business.general.domain.entity.Transaction;
import com.example.demo.business.general.domain.repository.TransactionRepository;
import com.example.demo.business.general.infrastructure.repository.mapper.TransactionMapper;
import com.example.demo.business.general.app.dto.TransactionDTO;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public void save(Transaction transaction) {
        TransactionDTO dto = TransactionDTO.fromEntity(transaction);
        transactionMapper.insert(dto);
    }

    @Override
    public Transaction findById(String transactionId) {
        TransactionDTO dto = transactionMapper.selectById(transactionId);
        return dto.toEntity();
    }

    @Override
    public void updateStatus(Transaction transaction) {
        TransactionDTO dto = TransactionDTO.fromEntity(transaction);
        transactionMapper.update(dto);
    }


} 