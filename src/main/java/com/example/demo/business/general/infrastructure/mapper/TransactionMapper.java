package com.example.demo.business.general.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.business.general.domain.entity.Transaction;

@Mapper
public interface TransactionMapper {
    
    /**
     * 插入交易流水记录
     */
    int insert(Transaction transaction);
    
    /**
     * 根据流水号查询交易记录
     */
    Transaction selectByTraceNum(String txTraceNum);
    
    /**
     * 更新交易状态
     */
    int updateStatus(String txTraceNum, String status);
} 