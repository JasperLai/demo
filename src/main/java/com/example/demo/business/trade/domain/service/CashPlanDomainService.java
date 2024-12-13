package com.example.demo.business.trade.domain.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.trade.domain.entity.CashPlan;
import com.example.demo.business.trade.domain.repository.CashPlanRepository;
import com.example.demo.business.trade.domain.valueobject.CashPlanStatus;

@Service
public class CashPlanDomainService {

    @Autowired
    private CashPlanRepository cashPlanRepository;

    /**
     * 获取待处理的付息兑付计划
     */
    public List<CashPlan> getPendingCashPlans(LocalDate workDate) {
        return cashPlanRepository.findByStatusAndWorkDate(CashPlanStatus.PENDING, workDate);
    }

    /**
     * 更新付息兑付计划状态
     */
    public void updateCashPlanStatus(CashPlan cashPlan, CashPlanStatus status) {
        cashPlanRepository.updateStatus(cashPlan, status);
    }

    /**
     * 批量创建付息兑付计划
     */
    public void createCashPlans(List<CashPlan> cashPlans) {
        cashPlanRepository.batchSave(cashPlans);
    }

    /**
     * 批量更新付息兑付计划状态
     */
    public void batchUpdateCashPlanStatus(List<CashPlan> cashPlans, CashPlanStatus status) {
        cashPlanRepository.batchUpdateStatus(cashPlans, status);
    }
} 