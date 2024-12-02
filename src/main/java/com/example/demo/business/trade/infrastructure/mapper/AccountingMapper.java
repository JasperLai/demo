package com.example.demo.business.trade.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.business.trade.domain.entity.Accounting;

@Mapper
public interface AccountingMapper {
    // 插入账务记录
    int insert(Accounting entity);
    
    // 根据交易流水号查询
    Accounting selectByTxTraceNum(@Param("txTraceNum") String txTraceNum);
    
    // 根据发起端交易流水号查询
    Accounting selectByInitTxTraceNum(@Param("initTxTraceNum") String initTxTraceNum);
    
    // 更新账务记录
    int update(Accounting entity);
} 