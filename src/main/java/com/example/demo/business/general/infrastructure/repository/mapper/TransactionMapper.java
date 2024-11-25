package com.example.demo.business.general.infrastructure.repository.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.demo.business.general.app.dto.TransactionDTO;

@Mapper
public interface TransactionMapper {

    void insert(TransactionDTO transaction);

    TransactionDTO selectById(String transactionId);

    void update(TransactionDTO transaction);

}
