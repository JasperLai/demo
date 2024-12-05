package com.example.demo.business.trade.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.business.trade.domain.entity.AccountingEntry;

@Mapper
public interface AccountingMapper {
    // 插入账务记录
    int insert(AccountingEntry entity);
    
    // 根据交易流水号查询
    AccountingEntry selectByTxTraceNum(@Param("txTraceNum") String txTraceNum);
    
    // 根据发起端交易流水号查询
    AccountingEntry selectByInitTxTraceNum(@Param("initTxTraceNum") String initTxTraceNum);
    
    // 更新账务记录
    int update(AccountingEntry entity);
} 