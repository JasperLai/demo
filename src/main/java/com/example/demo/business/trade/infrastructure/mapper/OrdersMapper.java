package com.example.demo.business.trade.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.business.trade.domain.entity.Order;

import java.util.List;

@Mapper
public interface OrdersMapper {
    // 插入订单
    int insert(Order entity);
    
    // 根据交易流水号查询
    Order selectByTxTraceNum(@Param("txTraceNum") String txTraceNum);
    
    // 根据交易账号查询订单列表
    List<Order> selectByTradeAcc(@Param("tradeAcc") String tradeAcc);
    
    // 更新订单
    int update(Order entity);
    
    // 根据产品代码查询订单列表
    List<Order> selectByProductId(@Param("productId") String productId);
} 