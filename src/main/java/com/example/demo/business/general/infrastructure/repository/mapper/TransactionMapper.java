package com.example.demo.business.general.infrastructure.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.general.domain.entity.Transaction;

@Mapper
public interface TransactionMapper {

    void insert(Transaction transaction);

    Transaction selectById(String transactionId);

    void updateStatus(String transactionId, TransStatus status);

    List<Transaction> selectByOperatorId(String operatorId);

}
