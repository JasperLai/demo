package com.example.demo.business.trade.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.business.trade.domain.entity.OrdersEntity;

import java.util.List;

@Mapper
public interface OrdersMapper {
    // 插入订单
    int insert(OrdersEntity entity);
    
    // 根据交易流水号查询
    OrdersEntity selectByTxTraceNum(@Param("txTraceNum") String txTraceNum);
    
    // 根据交易账号查询订单列表
    List<OrdersEntity> selectByTradeAcc(@Param("tradeAcc") String tradeAcc);
    
    // 更新订单
    int update(OrdersEntity entity);
    
    // 根据债券代码查询订单列表
    List<OrdersEntity> selectByBondCode(@Param("bondCode") String bondCode);
} 