package com.example.demo.business.trade.domain.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.business.trade.domain.entity.CashPlan;
import com.example.demo.business.trade.domain.valueobject.CashPlanStatus;

public interface CashPlanRepository {
    
    /**
     * 保存付息兑付计划
     */
    void save(CashPlan cashPlan);
    
    /**
     * 批量保存付息兑付计划
     */
    void batchSave(List<CashPlan> cashPlans);
    
    /**
     * 根据状态和工作日期查询付息兑付计划
     */
    List<CashPlan> findByStatusAndWorkDate(CashPlanStatus status, LocalDate workDate);
    
    /**
     * 更新付息兑付计划状态
     */
    void updateStatus(CashPlan cashPlan, CashPlanStatus status);
    
    /**
     * 根据债券代码查询付息兑付计划
     */
    List<CashPlan> findByBondCode(String bondCode);
    
    /**
     * 批量更新付息兑付计划状态
     */
    void batchUpdateStatus(List<CashPlan> cashPlans, CashPlanStatus status);
} 