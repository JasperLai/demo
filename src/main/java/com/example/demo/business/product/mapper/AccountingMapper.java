package com.example.demo.business.product.mapper;

import com.example.demo.business.product.domain.entity.AccountingEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountingMapper {
    // 插入账务记录
    int insert(AccountingEntity entity);
    
    // 根据交易流水号查询
    AccountingEntity selectByTxTraceNum(@Param("txTraceNum") String txTraceNum);
    
    // 根据发起端交易流水号查询
    AccountingEntity selectByInitTxTraceNum(@Param("initTxTraceNum") String initTxTraceNum);
    
    // 更新账务记录
    int update(AccountingEntity entity);
} 