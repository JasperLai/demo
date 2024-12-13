package com.example.demo.business.trade.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.business.trade.domain.entity.CashPlan;
import com.example.demo.business.trade.domain.repository.CashPlanRepository;
import com.example.demo.business.trade.domain.valueobject.CashPlanStatus;
import com.example.demo.business.trade.domain.valueobject.CashType;
import com.example.demo.business.trade.infrastructure.dto.CashPlanDTO;
import com.example.demo.business.trade.infrastructure.mapper.CashPlanMapper;

@Repository
public class CashPlanRepositoryImpl implements CashPlanRepository {

    @Autowired
    private CashPlanMapper cashPlanMapper;

    @Override
    public void save(CashPlan cashPlan) {
        cashPlanMapper.insert(convertToDTO(cashPlan));
    }

    @Override
    public void batchSave(List<CashPlan> cashPlans) {
        List<CashPlanDTO> dtos = cashPlans.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        cashPlanMapper.batchInsert(dtos);
    }

    @Override
    public List<CashPlan> findByStatusAndWorkDate(CashPlanStatus status, LocalDate workDate) {
        List<CashPlanDTO> dtos = cashPlanMapper.selectByStatusAndWorkDate(status.getCode(), workDate);
        return dtos.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void updateStatus(CashPlan cashPlan, CashPlanStatus status) {
        cashPlanMapper.updateStatus(
            cashPlan.getTradeAcc(),
            cashPlan.getBondCode(),
            cashPlan.getWorkDate(),
            status.getCode()
        );
    }

    @Override
    public List<CashPlan> findByBondCode(String bondCode) {
        List<CashPlanDTO> dtos = cashPlanMapper.selectByBondCode(bondCode);
        return dtos.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void batchUpdateStatus(List<CashPlan> cashPlans, CashPlanStatus status) {
        if (cashPlans == null || cashPlans.isEmpty()) {
            return;
        }
        
        // 每批处理的大小
        final int batchSize = 500;
        
        // 将列表分批处理
        for (int i = 0; i < cashPlans.size(); i += batchSize) {
            List<CashPlan> batch = cashPlans.subList(
                i, 
                Math.min(i + batchSize, cashPlans.size())
            );
            
            List<CashPlanDTO> dtos = batch.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
                    
            cashPlanMapper.batchUpdateStatus(dtos, status.getCode());
        }
    }

    private CashPlanDTO convertToDTO(CashPlan entity) {
        if (entity == null) {
            return null;
        }
        CashPlanDTO dto = new CashPlanDTO();
        dto.setTradeAcc(entity.getTradeAcc());
        dto.setBondCode(entity.getBondCode());
        dto.setCaptAcc(entity.getCaptAcc());
        dto.setWorkDate(entity.getWorkDate());
        dto.setAmount(entity.getAmount());
        dto.setCashType(entity.getCashType().getCode());
        dto.setStatus(entity.getStatus().getCode());
        dto.setRemark(entity.getRemark());
        return dto;
    }

    private CashPlan convertToEntity(CashPlanDTO dto) {
        if (dto == null) {
            return null;
        }
        CashPlan entity = new CashPlan();
        entity.setTradeAcc(dto.getTradeAcc());
        entity.setBondCode(dto.getBondCode());
        entity.setCaptAcc(dto.getCaptAcc());
        entity.setWorkDate(dto.getWorkDate());
        entity.setAmount(dto.getAmount());
        entity.setCashType(CashType.fromCode(dto.getCashType()));
        entity.setStatus(CashPlanStatus.fromCode(dto.getStatus()));
        entity.setRemark(dto.getRemark());
        return entity;
    }
} 