package com.example.demo.business.trade.infrastructure.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.business.trade.infrastructure.dto.CashPlanDTO;

@Mapper
public interface CashPlanMapper {
    
    void insert(CashPlanDTO cashPlanDTO);
    
    void batchInsert(@Param("list") List<CashPlanDTO> cashPlanDTOs);
    
    List<CashPlanDTO> selectByStatusAndWorkDate(@Param("status") String status, @Param("workDate") LocalDate workDate);
    
    void updateStatus(@Param("tradeAcc") String tradeAcc, 
                     @Param("bondCode") String bondCode,
                     @Param("workDate") LocalDate workDate,
                     @Param("status") String status);
    
    List<CashPlanDTO> selectByBondCode(@Param("bondCode") String bondCode);
    
    void batchUpdateStatus(@Param("list") List<CashPlanDTO> cashPlans, @Param("status") String status);
} 