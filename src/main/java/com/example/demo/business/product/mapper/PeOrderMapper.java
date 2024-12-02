package com.example.demo.business.product.mapper;

import com.example.demo.business.product.domain.entity.PeOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PeOrderMapper {
    // 插入PE订单
    int insert(PeOrderEntity entity);
    
    // 根据交易流水号查询
    PeOrderEntity selectByTxTraceNum(@Param("txTraceNum") String txTraceNum);
    
    // 根据PE订单号查询
    PeOrderEntity selectByPeOrderNum(@Param("peOrderNum") String peOrderNum);
    
    // 更新PE订单
    int update(PeOrderEntity entity);
} 